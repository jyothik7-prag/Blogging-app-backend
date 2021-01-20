package com.cg.blogging.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.blogging.dto.BloggerDto;
import com.cg.blogging.dto.UserDto;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.User;
import com.cg.blogging.exception.IdNotFoundException;


@Service
public interface UserService {
	
	public  User addNewUser(User user) ;

	public User signIn(String role,String password) throws IdNotFoundException;

	public User signOut(User user) ;

	public User removeUser(User ud) throws IdNotFoundException;


	public List<User> getAllUsers();
	public User updatePassword(User userDto) throws IdNotFoundException;
	public Blogger findBloggerthroughEmail(String role) ;

	

	

   
}