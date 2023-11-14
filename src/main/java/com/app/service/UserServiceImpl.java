package com.app.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.app.entity.User;
import com.app.repositiry.UserRepository;


@Service
public class UserServiceImpl{

	@Autowired
	private UserRepository Repo;
	
	
	public User adduser(User user) {

		Repo.save(user);	
		return user;
	}

	public List<User> findAll() {
		List<User> user=Repo.findAll();
		return user;
	}
	
	public User  updateuser(int id, User user) {
		try {
		User newuser=Repo.findById(id).get();
		if(user.getName()!=null) {
			newuser.setName(user.getName());
		}
		if(user.getDob()!=null) {
			newuser.setDob(user.getDob());
		}
		if(user.getEmail()!=null) {
			newuser.setEmail(user.getEmail());
		}
		if(user.getGender()!=null) {
			newuser.setGender(user.getGender());
		}
		if(user.getPhone()!=null) {
			newuser.setPhone(user.getPhone());
		}
		Repo.save(newuser);
		return newuser;
		}
		catch(Exception e)
    	{
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	}
	}


	public Optional<User> findById(int id) {
		User user=Repo.findById(id).get();
		return Optional.of(user);
	}

	public String deleteById(int id) {
		try {
		User user=Repo.findById(id).get();
		Repo.delete(user);
		return "user removed";
		}
		catch(Exception e)
    	{
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	}
	}


	public String delete(int id) {
		try {
		Repo.deleteById(id);
		return "user removed";
		}
		catch(Exception e)
    	{
    		throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    	}
	}



}
