package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.User;
import com.app.service.UserServiceImpl;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	@Autowired
	private UserServiceImpl service;
	
	@PostMapping("/adduser")
	public User saveuser(@RequestBody User user) {
		return service.adduser(user);
	}
	
	@GetMapping("/users")
	public List<User> findAll(){
		return service.findAll();
	}
	
	@PutMapping("user/update/{id}")
	public User  updateuser(@PathVariable int id,@RequestBody User user) {
		return service.updateuser(id, user);
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> findById(@PathVariable int id){
		return service.findById(id);
	}
	
	@DeleteMapping("/user/{id}")
	public String delete(@PathVariable int id) {
		return service.deleteById(id);
	}
	
}
