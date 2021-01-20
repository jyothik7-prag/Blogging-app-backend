package com.cg.blogging.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.blogging.dto.BloggerDto;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.exception.BloggerIdNotFoundException;
import com.cg.blogging.exception.IdNotFoundException;
import com.cg.blogging.exception.NullBloggerException;

@Service
	public interface BloggerService {
		public BloggerDto addBlogger(BloggerDto bloggerDto) throws NullBloggerException, IdNotFoundException ;
		public BloggerDto updateBlogger(BloggerDto bloggerDto) throws BloggerIdNotFoundException ;
		public List<BloggerDto> deleteBloggerById(int id) throws BloggerIdNotFoundException;
		public BloggerDto findBloggerById(int id) throws BloggerIdNotFoundException;
		public List<BloggerDto> viewAllBloggers();
		public Blogger retriveBloggerByEmail(String role);

}