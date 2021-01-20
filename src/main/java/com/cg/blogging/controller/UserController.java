package com.cg.blogging.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

//import org.apache.commons.logging.Log;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.blogging.BloggingAppApplication;
import com.cg.blogging.dao.UserJPARepository;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.User;
import com.cg.blogging.exception.IdNotFoundException;
import com.cg.blogging.service.UserService;

@Validated
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserJPARepository userJPARepository;
	
	private static final Logger log = LogManager.getLogger(BloggingAppApplication.class);
	
	
	@PostMapping("/user")
	public ResponseEntity<User> addNewUser(@Valid @RequestBody User user) {
		log.info("adding the new user");
		
		User user11 = userService.addNewUser(user);
	
		
		return new ResponseEntity("User added successfully !", HttpStatus.ACCEPTED);
	
		
	}

	@DeleteMapping(value = { "/deleteuser/{userId}" })
	public ResponseEntity<User> removeUser(@Valid @RequestBody User ud) throws IdNotFoundException {
		log.info("By this, your Id will be removed");
		User udto = userService.removeUser(ud);

		return new ResponseEntity("Your account has been removed successfully !", HttpStatus.ACCEPTED);
	}

	@PostMapping(value={"/signIn"})
	public ResponseEntity<Blogger> signIn(@RequestBody User user) throws IdNotFoundException {
		User u= userService.signIn(user.getRole(),user.getPassword());
		Blogger b=userService.findBloggerthroughEmail(user.getRole());
		return new ResponseEntity<Blogger>(b,HttpStatus.ACCEPTED);	
	}
	
	@PostMapping(value={"/signOut"})
	public ResponseEntity<User> signOut(@Valid @RequestBody User user){
		
		User u= userService.signOut(user);
		if(u==null) {
			return new ResponseEntity("no user found",HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity("signout Successfully",HttpStatus.ACCEPTED);
	}
	@GetMapping(value= {"/allusers"})
	    public List<User> getAllUsers() {
		   List<User> all = userService.getAllUsers();
	        return all;
	    }


}