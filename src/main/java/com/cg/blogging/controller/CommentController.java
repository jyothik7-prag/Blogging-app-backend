package com.cg.blogging.controller;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.cg.blogging.dto.CommentDto;
import com.cg.blogging.entities.Comment;
import com.cg.blogging.entities.Community;
import com.cg.blogging.exception.CommunityIdNotFoundException;
import com.cg.blogging.exception.IdNotFoundException;
import com.cg.blogging.service.CommentService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class CommentController
{
	private static final Logger log = LogManager.getLogger(BloggingAppApplication.class);
	
	@Autowired
	private CommentService commentService;
	
//	End point for insert
	
	@PostMapping("/comments")
	public ResponseEntity<CommentDto> insertComment(
			@RequestBody CommentDto commentDto){
		log.info("Controller layer- add method-entry");
		CommentDto commentDtoAdd=null;
		commentDtoAdd= commentService.addComment(commentDto);
		if(commentDtoAdd==null)
		{
			log.warn("No comments to return after insertion");
			return new ResponseEntity("Sorry! Comments are null!", HttpStatus.UNPROCESSABLE_ENTITY);
		}
		log.info("Controller layer- add method-exit");
		return new ResponseEntity<CommentDto>(commentDtoAdd, HttpStatus.OK);
	}
	
	@GetMapping("/commentspost/{postId}")
	public ResponseEntity<List<CommentDto>> findCommentByPost(@PathVariable("postId") Integer id)
	{
		List<CommentDto> commentDto=new ArrayList<CommentDto>();
		commentDto=commentService.findCommentsByPostId(id);
		return new ResponseEntity<List<CommentDto>>(commentDto, HttpStatus.OK);	
	}
	
//	End point for delete
	
	@DeleteMapping("/comment/{commentId}")
	public ResponseEntity<List<CommentDto>> deleteComment(@PathVariable("commentId")Integer commentId) throws IdNotFoundException{
		log.info("Controller layer- delete method-entry");
		List<CommentDto> comments=null;
		comments= commentService.deleteCommentById(commentId);
		if(comments==null) 
		{
			log.warn("No comments to return after deletion");
			return new ResponseEntity("Sorry! Comment is not available!", HttpStatus.NOT_FOUND);
		}
		log.info("Controller layer- delete method-exit");
		return new ResponseEntity<List<CommentDto>>(comments, HttpStatus.OK);
	}
	
//	End point for find all
	
	@GetMapping("/comments")
	public ResponseEntity<List<CommentDto>> findAllComments(){
		log.info("Controller layer- find all comments method-entry");
		List<CommentDto> comments = commentService.viewAllComments();
		if(comments.isEmpty())
		{
			log.warn("No comments to return");
			return new ResponseEntity("Sorry! No Comments found!", HttpStatus.NOT_FOUND);
		}
		log.info("Controller layer- find all comments method- exit");
		return new ResponseEntity<List<CommentDto>>(comments, HttpStatus.OK);
		
	}
	
//	End point for find by id
	@GetMapping("/comment/{commentId}")
	public ResponseEntity<CommentDto> findCommentsThroughId(@PathVariable("commentId")Integer commentId) throws IdNotFoundException{
		log.info("Controller layer- find by id method-entry");
		CommentDto comment=null;
			comment= commentService.findCommentsById( commentId);
		if(comment==null)
		{
			return new ResponseEntity("Sorry! Community not found!", HttpStatus.NOT_FOUND);
		
		}
		log.info("Controller layer- find by id method-exit");
		return new ResponseEntity<CommentDto>(comment, HttpStatus.OK);	
	}
	
//	End point for Update
	@PutMapping("/comment")
	public ResponseEntity<CommentDto> updateComment(@Valid @RequestBody CommentDto commentDto)
			throws IdNotFoundException {
		log.info("Controller layer- update method-entry");
		CommentDto comments = null;
		comments = commentService.updatecomment(commentDto);
		if (comments==null) {
			log.warn("No comments found");
			return new ResponseEntity("Sorry! Comment is not available!", HttpStatus.NOT_FOUND);
		}
		log.info("Controller layer- update method-exit");
		return new ResponseEntity<CommentDto>(comments, HttpStatus.OK);
	}
	
}