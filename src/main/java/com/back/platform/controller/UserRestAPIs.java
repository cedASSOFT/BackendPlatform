package com.back.platform.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.back.platform.model.User;
import com.back.platform.repository.UserRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserRestAPIs {
	
	@Autowired
	UserRepository userRepository;
	
	//Begin CRUD user model
	@GetMapping("/admin/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/admin/user/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public Optional<User> getUser(@PathVariable Long id) {
		return userRepository.findById(id);
	}
	
	
	@DeleteMapping("/admin/delete/user/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public boolean deleteUser(@PathVariable Long id) {
		userRepository.deleteById(id);
		return true;
	}

	@PutMapping("/admin/update/user")
	@PreAuthorize("hasRole('ADMIN')")
	public User updateUser(@RequestBody User user) {
		return userRepository.save(user);
	}
	
	//End CRUD user model
	
	
	//initial
	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
		return ">>> User Contents!";
	}

	@GetMapping("/pm")
	@PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
	public String projectManagementAccess() {
		return ">>> Project Management Board";
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return ">>> Admin Contents";
	}
}