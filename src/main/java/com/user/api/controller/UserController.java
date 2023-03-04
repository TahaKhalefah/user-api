package com.user.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.user.api.model.request.UserReqModel;
import com.user.api.model.response.UserBaseInfoResModel;
import com.user.api.model.response.UserResModel;
import com.user.api.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public UserBaseInfoResModel createUser(@RequestBody UserReqModel userReqModel) {
		return userService.createUser(userReqModel);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserResModel> getUserByIdAndAccessToken(@PathVariable String id,
			@RequestParam String accessToken) {
		Optional<UserResModel> optionalUser = userService.getUserByIdAndAccessToken(id, accessToken);

		if (optionalUser.isPresent()) {
			return ResponseEntity.ok(optionalUser.get());
		}

		return ResponseEntity.notFound().build();
	}
}
