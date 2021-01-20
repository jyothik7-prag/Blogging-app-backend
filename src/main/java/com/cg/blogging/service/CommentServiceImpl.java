package com.cg.blogging.service;

import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.blogging.dao.CommentJPARepository;
import com.cg.blogging.dto.BloggerDto;
import com.cg.blogging.dto.CommentDto;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Comment;
import com.cg.blogging.entities.Community;
import com.cg.blogging.entities.Post;
import com.cg.blogging.exception.BloggerIdNotFoundException;
import com.cg.blogging.exception.CommunityIdNotFoundException;
import com.cg.blogging.exception.IdNotFoundException;
//@Transactional
@Service
public class CommentServiceImpl implements CommentService {

	static Logger log = Logger.getLogger(CommentServiceImpl.class.getName());
	
	public Comment convertDtotoEntity(CommentDto commentDto){
	Comment commentEntity=new Comment();
	commentEntity.setCommentId(commentDto.getCommentId());
	commentEntity.setCommentDescription(commentDto.getCommentDescription());
	commentEntity.setVotes(commentDto.getVotes());
	commentEntity.setBlogger(commentDto.getBlogger());
	commentEntity.setPost(commentDto.getPost());
	commentEntity.setVoteUp(commentDto.isVoteUp());

	return commentEntity;
	}

	public CommentDto convertEntitytoDto(Comment comment){
	CommentDto commentDto=new CommentDto();
	commentDto.setCommentId(comment.getCommentId());
	commentDto.setCommentDescription(comment.getCommentDescription());
	commentDto.setVotes(comment.getVotes());
	commentDto.setBlogger(comment.getBlogger());
	commentDto.setPost(comment.getPost());
	commentDto.setVoteUp(comment.isVoteUp());

	return commentDto;
	}

	@Autowired
	private CommentJPARepository commentJPARepository;

	@Override
	public CommentDto addComment(CommentDto commentDto) {
		if(commentDto==null)
		{
			return null;
		}
		else {
			Comment commentEntity=convertDtotoEntity(commentDto);
			log.info("Service Layer - Entry - addComment");
			Comment comment1=commentJPARepository.saveAndFlush(commentEntity);
			System.out.println("after sav eand flish" +comment1);
			commentDto=convertEntitytoDto(comment1);
			System.out.println("convertEntity to dto" +commentDto);

			log.info("Service Layer - Exit - addComment");
			System.out.println(commentDto);
			return commentDto;		
		
		}
	}

	@Override
	public List<CommentDto> deleteCommentById(int id) throws IdNotFoundException {
		Optional<Comment> commentNull = Optional.empty();
		if(commentJPARepository.findById(id) != commentNull)
		{
			
			log.info("Delete comment by Id not started");
			commentJPARepository.deleteById(id);
			log.info("Delete comment by Id ended");
			List<Comment> comment= commentJPARepository.findAll();
			List<CommentDto> commentDto=new ArrayList<CommentDto>();
			
			for(Comment c:comment)
			{
				commentDto.add( convertEntitytoDto(c));
			}
			
			return commentDto;
		}
		else {
		throw new IdNotFoundException("Deletion failed! Comment with "+id+" is not found!");
		}

	}

	@Override
	public List<CommentDto> viewAllComments(){
		List<Comment> comments = null;
		log.info("Service Layer - Entry - retrieveAllComments");
		comments = commentJPARepository.findAll();
		//System.out.println(comments);
		log.info("Service Layer - Exit - retrieveAllComments");
		List<CommentDto> commentDto=new ArrayList<CommentDto>();
		for(Comment c:comments)
		{
			commentDto.add(convertEntitytoDto(c));
		}
		return commentDto;
	}	

	@Override
	public CommentDto findCommentsById(int id) throws IdNotFoundException {
		Optional<Comment> comment = null;
		if (commentJPARepository.existsById(id)) {
			log.info("Service Layer - Entry - retrieveComment");
			comment = commentJPARepository.findById(id);
			Comment comment1=comment.get();
			System.out.println(comment1);
			log.info("Service Layer - Exit - retrieveComment");
			return  convertEntitytoDto(comment1);
		}
		throw new IdNotFoundException("comment with " + id + " not found in the table!");
	}

	@Override
	public CommentDto updatecomment(CommentDto commentDto) throws IdNotFoundException {
		Comment commentEntity= convertDtotoEntity(commentDto);
		if (commentJPARepository.existsById(commentEntity.getCommentId())) {
			
			log.info("Service Layer - Entry - updateComment");
			Comment comment=commentJPARepository.save(commentEntity);
			
			commentDto= convertEntitytoDto(comment);
			log.info("Service Layer - Exit - updateComment");
			return commentDto;
		}
		throw new IdNotFoundException("Updation failed! Comment with " + commentDto.getCommentId() + " is not found!");
	}

	@Override
	public List<CommentDto> findCommentsByPostId(int id) {
		List<Comment> comments=commentJPARepository.searchCommentsByPost(id);
		List<CommentDto> commentDto=new ArrayList<CommentDto>();
		for(Comment c:comments)
		{
			commentDto.add(convertEntitytoDto(c));
		}
		return commentDto;
	}

}