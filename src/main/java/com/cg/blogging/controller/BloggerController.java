package com.cg.blogging.controller;

import java.util.List;

import javax.validation.Valid;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

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
import com.cg.blogging.dto.BloggerDto;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.exception.BloggerIdNotFoundException;
import com.cg.blogging.exception.IdNotFoundException;
import com.cg.blogging.exception.NullBloggerException;
import com.cg.blogging.service.BloggerService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@Validated
public class BloggerController {
	@Autowired
	private BloggerService bloggerService;
	private static final Logger log = LogManager.getLogger(BloggingAppApplication.class);
    
	//Adding blogger and returning all bloggers
	@PostMapping("/bloggerAdd")
	  public ResponseEntity<BloggerDto> addBlogger(@Valid  @RequestBody BloggerDto bloggerDto) throws NullBloggerException, IdNotFoundException {
		log.info("Controller Layer - Entry - addBlogger");
		log.info("Controller Layer - Exit - addBlogger");
        BloggerDto bloggerDtoAdd = null;
        bloggerDtoAdd= bloggerService.addBlogger(bloggerDto);
        return new ResponseEntity<BloggerDto>(bloggerDtoAdd, HttpStatus.OK);
    }

	//Updating blogger and returning all bloggers
	@PutMapping("/blogger")
	public ResponseEntity<BloggerDto> updateBlogger(@RequestBody BloggerDto bloggerDto) throws BloggerIdNotFoundException{
		log.info("Controller Layer - Entry - updateBlogger");
		log.info("Controller Layer - Exit - updateBlogger");
		BloggerDto bloggers = null;
		bloggers = bloggerService.updateBlogger(bloggerDto);
		return new ResponseEntity<BloggerDto>(bloggers, HttpStatus.OK);
	}
	
	//Deleting blogger using Id and returning all bloggers
	@DeleteMapping("/blogger/{userId}")
	public ResponseEntity<List<BloggerDto>> deleteBlogger(@PathVariable("userId") Integer userId) throws BloggerIdNotFoundException{
		log.info("Controller Layer - Entry - deleteBlogger");
		log.info("Controller Layer - Exit - deleteBlogger");
		List<BloggerDto> bloggers = null;
		bloggers = bloggerService.deleteBloggerById(userId);
		return new ResponseEntity<List<BloggerDto>>(bloggers, HttpStatus.OK);
	}
	
	//Seaarch blogger with Id and displays that particular blogger 
	@GetMapping("/blogger/{userId}")
	public ResponseEntity<BloggerDto> findBlogger(@PathVariable("userId")Integer userId) throws BloggerIdNotFoundException{
		log.info("Controller Layer - Entry - retrieveBloggerById");
		log.info("Controller Layer - Exit - retrieveBloggerById");

		BloggerDto bloggerDto = null;
			bloggerDto = bloggerService.findBloggerById(userId);
		return new ResponseEntity<BloggerDto>(bloggerDto, HttpStatus.OK);	
	}

//	@PostMapping("/blogger/{role}")
//	public ResponseEntity<BloggerDto> retrieveBlogger(@PathVariable("role") String role){
//		BloggerDto blogger=null;
//		blogger = bloggerService.retriveBloggerByEmail(role);
//		return new ResponseEntity<BloggerDto>(blogger,HttpStatus.OK);
//	}
	
	
	//retrieves all bloggers and displays all
	@GetMapping("/bloggers")
	public ResponseEntity<List<BloggerDto>> getAllBloggers(){
		List<BloggerDto> bloggers= bloggerService.viewAllBloggers();
		log.info("Controller Layer - Entry - retrieveALLBloggers");
		log.info("Controller Layer - Exit - retrieveAllBloggers");
		if(bloggers==null) {
			return new ResponseEntity("Sorry! Bloggers not available!", HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<BloggerDto>>(bloggers, HttpStatus.OK);
	}

}