package com.user.api.service.impl;

import java.util.Date;
import java.util.Optional;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.user.api.entity.User;
import com.user.api.model.request.UserReqModel;
import com.user.api.model.response.UserBaseInfoResModel;
import com.user.api.model.response.UserResModel;
import com.user.api.repository.UserRepository;
import com.user.api.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Service
public class UserServiceImpl implements UserService {

	@Value("${salt}")
	private String salt;

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserBaseInfoResModel createUser(UserReqModel userReqModel) {
		User user = new User();
		mapToUserReqModel(userReqModel, user);
		return mapToUserBaseInfoResModel(user);
	}

	@Override
	public Optional<UserResModel> getUserByIdAndAccessToken(String id, String accessToken) {
		Optional<User> optionalUser = userRepository.findByIdAndAccessToken(id, accessToken);

		if (optionalUser.isPresent()) {
			// Return user without email if marketingConsent is false But email not exist in
			// response model!!
			User user = optionalUser.get();
			if (!user.isMarketingConsent()) {
				user.setEmail(null);
			}

			return Optional.of(mapToUserResModel(user));
		}

		return Optional.empty();
	}

	// ************* Private Methods ************

	private UserBaseInfoResModel mapToUserBaseInfoResModel(User user) {
		UserBaseInfoResModel userBaseInfoResModel = new UserBaseInfoResModel();
		userBaseInfoResModel.setId(user.getId());
		userBaseInfoResModel.setAccessToken(user.getAccessToken());
		return userBaseInfoResModel;
	}

	private UserResModel mapToUserResModel(User user) {
		UserResModel userResModel = new UserResModel();
		userResModel.setId(user.getId());
		userResModel.setFirstName(user.getFirstName());
		userResModel.setLastName(user.getLastName());
		userResModel.setMarketingConsent(user.isMarketingConsent());
		return userResModel;
	}

	private void mapToUserReqModel(UserReqModel userReqModel, User user) {
		user.setId(prepareUserId(user.getEmail()));
		user.setAccessToken(getJwtToken(user));
		user.setEmail(userReqModel.getEmail());
		user.setFirstName(userReqModel.getFirstName());
		user.setLastName(userReqModel.getLastName());
		user.setMarketingConsent(userReqModel.isMarketingConsent());
	}

	private String prepareUserId(String userEmail) {
		return DigestUtils.sha1Hex(userEmail + salt);
	}

	private String getJwtToken(User user) {
		return Jwts.builder().setSubject(user.getEmail()).setIssuedAt(new Date())
				.signWith(Keys.secretKeyFor(SignatureAlgorithm.HS256)).compact();
	}

}
