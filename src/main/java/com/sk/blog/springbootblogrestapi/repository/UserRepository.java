package com.sk.blog.springbootblogrestapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.blog.springbootblogrestapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUserNameOrEmail(String userName, String email);
	Optional<User> findByEmail(String email);
	Optional<User> findByUserName(String userName);
	Boolean existsByUserName(String userName);
	Boolean existsByEmail(String email);

}
