package com.cg.blogging.service;

import java.util.List;

import com.cg.blogging.dto.PostDto;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Post;

import com.cg.blogging.exception.IdNotFoundException;

public interface PostService {
	

	
    public PostDto addPost(PostDto postDto) throws IdNotFoundException;
	public  PostDto updatePost(PostDto postDto) throws IdNotFoundException;
	public List<PostDto> deletePostById(int id) throws IdNotFoundException;
	public List<PostDto> viewAllPosts() ;
	public PostDto findPostById(int id) throws IdNotFoundException;
    
	
	
	 
	

}