package com.cg.blogging.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.cg.blogging.dto.PostDto;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Post;

import com.cg.blogging.exception.IdNotFoundException;

import com.cg.blogging.service.PostService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private PostService postService;
    private static final Logger log = LogManager.getLogger(BloggingAppApplication.class);
    
    
    @GetMapping("/posts")
    public ResponseEntity<List<PostDto>> viewAllPosts() {
    	
    	log.info("Controller Layer - Entry - retrieveALLPosts");
		log.info("Controller Layer - Exit - retrieveAllPosts");
		
    	
        List<PostDto> posts = postService.viewAllPosts();
        if (posts.isEmpty()) {
            return new ResponseEntity("Sorry! Bloggers not found!", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);

 

    }
    @GetMapping("/posts/{id}")
    public ResponseEntity<PostDto> findPost(@PathVariable int id) throws IdNotFoundException {
    	PostDto postDto=null;
    	postDto=postService.findPostById(id);
    	 return new ResponseEntity<PostDto>(postDto, HttpStatus.OK);

    
    	
    }
    
    
    
    
    
    

    @PostMapping("/posts")
    public ResponseEntity<PostDto> addPost(  @RequestBody PostDto postDto) throws IdNotFoundException {
    	log.info("Controller Layer - Entry - Post");
    	log.info("Controller Layer - Exit - addPost");
        PostDto postDtoAdd = null;
        postDtoAdd=postService.addPost(postDto);
        return new ResponseEntity<PostDto>(postDtoAdd, HttpStatus.OK);
    }
	
    
    

    @PutMapping("/posts")
	public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto) throws IdNotFoundException{
    	log.info("Controller Layer - Entry - updatePost");
		log.info("Controller Layer - Exit - updatePost");
    	
		PostDto posts=null;
		posts= postService.updatePost(postDto);
		
		return new ResponseEntity<PostDto>(posts, HttpStatus.OK);
	}
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<List<PostDto>> deletePost(@PathVariable int id) throws IdNotFoundException {
    	log.info("Controller Layer - Entry - deletePost");
		log.info("Controller Layer - Exit - deletePost");
    	
        List<PostDto> posts =null;
        posts=postService.deletePostById(id);
        return new ResponseEntity<List<PostDto>>(posts, HttpStatus.OK);
    }

  
   
    

   
   
    
   

   
}