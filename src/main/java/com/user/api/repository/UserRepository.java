package com.user.api.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.user.api.entity.User;

public interface UserRepository extends CrudRepository<User, String> {

	Optional<User> findByIdAndAccessToken(String id, String accessToken);

}
