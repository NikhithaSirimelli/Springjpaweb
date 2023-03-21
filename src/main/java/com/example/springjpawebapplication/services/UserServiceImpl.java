package com.example.springjpawebapplication.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springjpawebapplication.model.User;
import com.example.springjpawebapplication.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	private final UserRepository userRepository;

	public UserServiceImpl(@Autowired UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User getUser(Integer id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElse(null);
	}

	@Override
	public User save(User user) {

		return userRepository.save(user);
	}

	@Override
	public void delete(Integer id) {
		userRepository.deleteById(id);

	}

}
