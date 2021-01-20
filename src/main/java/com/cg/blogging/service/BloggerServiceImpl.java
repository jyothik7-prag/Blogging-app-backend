package com.cg.blogging.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.blogging.dao.BloggerJPARepository;
import com.cg.blogging.dao.CommentJPARepository;
import com.cg.blogging.dao.PostJPARepository;
import com.cg.blogging.dao.UserJPARepository;
import com.cg.blogging.dto.BloggerDto;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Comment;
import com.cg.blogging.entities.Post;
import com.cg.blogging.entities.User;
import com.cg.blogging.exception.BloggerIdNotFoundException;
import com.cg.blogging.exception.IdNotFoundException;
import com.cg.blogging.exception.NullBloggerException;

@Service
public class BloggerServiceImpl implements BloggerService {

	static Logger log = Logger.getLogger(BloggerServiceImpl.class.getName());

	@Autowired
	private BloggerJPARepository bloggerJPARepository;
	
//	BloggerServiceImpl  =new BloggerServiceImpl();

	
	public Blogger convertDtotoEntity(BloggerDto bloggerDto)
	{
		Blogger bloggerEntity=new Blogger();
		
		bloggerEntity.setBloggerId(bloggerDto.getBloggerId());
		bloggerEntity.setBloggerName(bloggerDto.getBloggerName());
		bloggerEntity.setComment(bloggerDto.getComment());
		bloggerEntity.setCommunities(bloggerDto.getCommunities());
		bloggerEntity.setDownvoted(bloggerDto.getDownvoted());
		bloggerEntity.setPosts(bloggerDto.getPosts());
		bloggerEntity.setUpvoted(bloggerDto.getUpvoted());
		bloggerEntity.setUser(bloggerDto.getUser());
		
		return bloggerEntity;
		
	}
	
	public BloggerDto convertEntitytoDto(Blogger blogger)
	{
		BloggerDto bloggerDto=new BloggerDto();
		
		bloggerDto.setBloggerId(blogger.getBloggerId());
		bloggerDto.setBloggerName(blogger.getBloggerName());
		bloggerDto.setComment(blogger.getComment());
		bloggerDto.setCommunities(blogger.getCommunities());
		bloggerDto.setDownvoted(blogger.getDownvoted());
		bloggerDto.setPosts(blogger.getPosts());
		bloggerDto.setUpvoted(blogger.getUpvoted());
		bloggerDto.setUser(blogger.getUser());
		
		return bloggerDto;
		
	}

	@Override
	public BloggerDto addBlogger(BloggerDto bloggerDto) throws NullBloggerException, IdNotFoundException {
		if(bloggerDto==null)
		{
			  throw new NullBloggerException("No blogger added because the object passed is null");
				
			}
		else {
			Blogger bloggerEntity=convertDtotoEntity(bloggerDto);
			log.info("Service Layer - Entry - addBlogger");	
		//	List<Blogger> bloggerList= bloggerJPARepository.findAll();
			
			Blogger bloggerByEmail=bloggerJPARepository.retriveBloggerThroughEmail(bloggerEntity.getUser().getRole());
			Blogger bloggerReturn;
			Blogger bloggerDtoAdd = null;
			if(bloggerByEmail==null) {
				bloggerReturn=bloggerJPARepository.saveAndFlush(bloggerEntity);
				log.info("Service Layer - Exit - addBlogger");
				return convertEntitytoDto(bloggerReturn);
			}
				else {
					throw new NullBloggerException("Email already exist");
				}
		}
	}
			
			
				
				
	
	
	@Override
	public Blogger retriveBloggerByEmail(String role) {
		Blogger b = bloggerJPARepository.retriveBloggerThroughEmail(role);
		return b;	
	}


	@Override
	public BloggerDto updateBlogger(BloggerDto bloggerDto) throws BloggerIdNotFoundException {
		Blogger bloggerEntity= convertDtotoEntity(bloggerDto);
		if (bloggerJPARepository.existsById(bloggerEntity.getBloggerId())) {
			
			log.info("Service Layer - Entry - updateBlogger");
			Blogger blogger=bloggerJPARepository.save(bloggerEntity);
			
			bloggerDto= convertEntitytoDto(blogger);
			log.info("Service Layer - Exit - updateBlogger");
			return bloggerDto;
		}
		throw new BloggerIdNotFoundException("Updation failed! Blogger with " + bloggerDto.getBloggerId() + " is not found!");
	}

	@Override
	public List<BloggerDto> deleteBloggerById(int id) throws BloggerIdNotFoundException {
		Optional<Blogger> bloggerNull = Optional.empty();
		if(bloggerJPARepository.findById(id) != bloggerNull)
		{
			
			log.info("Delete blogger by Id not started");
			bloggerJPARepository.deleteById(id);
			log.info("Delete blogger by Id ended");
			List<Blogger> blogger= bloggerJPARepository.findAll();
			List<BloggerDto> bloggerDto=new ArrayList<BloggerDto>();
			
			for(Blogger b:blogger)
			{
				bloggerDto.add( convertEntitytoDto(b));
			}
			
			return bloggerDto;
		}
		else {
		throw new BloggerIdNotFoundException("Deletion failed! Blogger with "+id+" is not found!");
		}

	}

	@Override
	public BloggerDto findBloggerById(int id) throws BloggerIdNotFoundException {
		Optional<Blogger> blogger = null;
		if (bloggerJPARepository.existsById(id)) {
			log.info("Service Layer - Entry - retrieveBlogger");
			blogger = bloggerJPARepository.findById(id);
			Blogger blogger1=blogger.get();
			log.info("Service Layer - Exit - retrieveBlogger");
			return  convertEntitytoDto(blogger1);
		}
		throw new BloggerIdNotFoundException("blogger with " + id + " not found in the table!");
	}

	@Override
	public List<BloggerDto> viewAllBloggers() {
		List<Blogger> bloggers = null;
		log.info("Service Layer - Entry - retrieveAllBloggers");
		bloggers = bloggerJPARepository.findAll();
		log.info("Service Layer - Exit - retrieveAllBloggers");
		List<BloggerDto> bloggerDto=new ArrayList<BloggerDto>();
		for(Blogger b:bloggers)
		{
			bloggerDto.add(convertEntitytoDto(b));
		}
		return bloggerDto;
	}
	
}