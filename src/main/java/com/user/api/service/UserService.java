package com.user.api.service;

import java.util.Optional;

import com.user.api.model.request.UserReqModel;
import com.user.api.model.response.UserBaseInfoResModel;
import com.user.api.model.response.UserResModel;

public interface UserService {

	public UserBaseInfoResModel createUser(UserReqModel userReqModel);

	public Optional<UserResModel> getUserByIdAndAccessToken(String id, String accessToken);
}
