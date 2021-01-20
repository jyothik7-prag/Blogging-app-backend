package com.cg.blogging.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.blogging.dao.PostJPARepository;
import com.cg.blogging.dto.BloggerDto;
import com.cg.blogging.dto.PostDto;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Post;
import com.cg.blogging.exception.BloggerIdNotFoundException;
import com.cg.blogging.exception.IdNotFoundException;

@Service
public class PostServiceImpl implements PostService{
	static Logger log = Logger.getLogger(PostServiceImpl.class.getName());

	
	@Autowired
	private PostJPARepository  postJPARepository;

	@Override
	public PostDto updatePost(PostDto postDto) throws IdNotFoundException {
		log.info("Service Layer - Entry - updatePost");
		Post postEntity=convertDtotoEntity(postDto);
			if(postJPARepository.existsById(postEntity.getPostId()))
			{
				Post post=postJPARepository.save(postEntity);
				postDto=convertEntitytoDto(post);
				return postDto;
			}
			log.info("Service Layer - Exit - updatePost");
				throw new IdNotFoundException("post can not be updated.no post found");
	
			
}

	
	 public List<PostDto> viewAllPosts() {
		 log.info("Service Layer - Entry - retrieveallPosts");
	        
	        List<Post> posts=null;
	        posts=postJPARepository.findAll();
	        log.info("Service Layer - Exit - retrieveallposts");
	        List<PostDto> postDto=new ArrayList<PostDto>();
	        for(Post p:posts)
	        {
	        	postDto.add(convertEntitytoDto(p));
	        
	        }
	        return postDto;
	    }
	 
		@Override
	 public PostDto findPostById(int id) throws IdNotFoundException {
			Optional<Post> post = null;
			if (postJPARepository.existsById(id)) {
				log.info("Service Layer - Entry - retrievePost");
				post = postJPARepository.findById(id);
				Post post1=post.get();
				log.info("Service Layer - Exit - retrievePost");
				return  convertEntitytoDto(post1);
			}
			throw new IdNotFoundException("post with " + id + " not found in the table!");
		}

	@Override
	public List<PostDto> deletePostById(int id) throws IdNotFoundException {
		Optional<Post> postNull=Optional.empty();
		
			if(postJPARepository.findById(id) != postNull)
			{
				log.info("Service Layer - Entry - deletePost");
				postJPARepository.deleteById(id);
				log.info("Service Layer - Exit - deletePost");
				List<Post> post=postJPARepository.findAll();
				List<PostDto> postDto=new ArrayList<PostDto>();
				return postDto;
				
			}
			else {
				    throw new IdNotFoundException("deletion failed,no post found with given id " +id);
				}
		}
		    


	@Override
	public PostDto addPost(PostDto postDto) throws IdNotFoundException {
		log.info("Service Layer - Entry - addPost");
		log.info("Service Layer - Exit - addPost");
		
		if(postDto==null)
		{
			throw new IdNotFoundException("can not add a post");
			}
		else {

			Post postEntity=convertDtotoEntity(postDto);
			Post post1=postJPARepository.saveAndFlush(postEntity);
			postDto=convertEntitytoDto(post1);
			return postDto;		
		
		}
	}
	public Post convertDtotoEntity(PostDto postDto)
	{
		Post postEntity=new Post();
		postEntity.setPostId(postDto.getPostId());
		postEntity.setTitle(postDto.getTitle());
		postEntity.setCreatedBy(postDto.getCreatedBy());
		postEntity.setContent(postDto.getContent());
		postEntity.setCreatedDateTime(postDto.getCreatedDateTime());
		postEntity.setComments(postDto.getComments());
		postEntity.setVotes(postDto.getVotes());
		postEntity.setVoteUp(postDto.isVoteUp());
		postEntity.setNotSafeForWork(postDto.isNotSafeForWork());
		postEntity.setSpoiler(postDto.isSpoiler());
		postEntity.setOriginalContent(postDto.isOriginalContent());
		postEntity.setFlair(postDto.getFlair());
		postEntity.setCommunity(postDto.getCommunity());
		
		return postEntity;
	}
	public PostDto convertEntitytoDto(Post post)
	{
		PostDto postDto=new PostDto();
		postDto.setPostId(post.getPostId());
		postDto.setTitle(post.getTitle());
		postDto.setCreatedBy(post.getCreatedBy());
		postDto.setContent(post.getContent());
		postDto.setCreatedDateTime(post.getCreatedDateTime());
		postDto.setComments(post.getComments());
		postDto.setVotes(post.getVotes());
		postDto.setVoteUp(post.isVoteUp());
		postDto.setNotSafeForWork(post.isNotSafeForWork());
		postDto.setSpoiler(post.isSpoiler());
		postDto.setOriginalContent(post.isOriginalContent());
		postDto.setFlair(postDto.getFlair());
		postDto.setCommunity(post.getCommunity());
		return postDto;
		
		
		
	}
	
}