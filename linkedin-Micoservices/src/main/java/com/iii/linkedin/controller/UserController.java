package com.iii.linkedin.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.iii.linkedin.dao.UserDaoService;
import com.iii.linkedin.model.User;
import com.iii.linkedin.model.UserNotFoundException;

@RestController
@RequestMapping("/Udumy/users")
public class UserController {

	@Autowired
	private UserDaoService userDaoService;

	@GetMapping
	public List<User> retriveAllUsers() {
		return userDaoService.findAll();

	}

	@GetMapping("{id}")
	public User retriveAllUsers(@PathVariable int id) {
		User user = userDaoService.findById(id);
		if (null == user)
			throw new UserNotFoundException("id-" + id);
		return (user);

	}

	@PostMapping
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userDaoService.save(user);

		URI currentReqUri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getId()).toUri();
		return ResponseEntity.created(currentReqUri).build();
	}

	@DeleteMapping("{id}")
	public void deleteUser(@PathVariable int id) {

		User deletedUser = userDaoService.deleteById(id);

		if (null == deletedUser)
			throw new UserNotFoundException("id-" + id);
	//	return (deletedUser);

	}

}
