//package com.cg.blogging.application;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.cg.blogging.dao.CommentJPARepository;
//import com.cg.blogging.entities.Comment;
//import com.cg.blogging.entities.Community;
//import com.cg.blogging.exception.CommunityIdNotFoundException;
//import com.cg.blogging.exception.IdNotFoundException;
//import com.cg.blogging.service.CommentServiceImpl;
//
//@SpringBootTest
//public class CommentServiceTest {
//
//	@MockBean
//	private CommentJPARepository commentJPARepository;
//	
//	@Autowired
//	private CommentServiceImpl commentService;
//	
//	Comment comment1=new Comment(101,"Nice post",10,null,null,true);
//	Comment comment2=new Comment("Keep going:)",10,null,null,true);
//	Comment comment3=new Comment(103,"Nice post",10,null,null,true);
//	Comment comment4=new Comment(104,"Nice post",10,null,null,true);
//	
//	
//	@Test
//	@DisplayName("Check for addition successful")
//	public void testAddComment()
//	{
//		List<Comment> comments=new ArrayList<>();
//		comments.add(comment2);
//		when(commentJPARepository.saveAndFlush(comment2)).thenReturn(comment2);
//		when(commentJPARepository.findAll()).thenReturn(comments);
//		List<Comment> commentsReturn=commentService.addComment(comment2);
//		assertEquals(comments.size(),commentsReturn.size());
//	}
//	
//	@Test
//	@DisplayName("Check for addition failure")
//	public void testAddNull()
//	{
//		List<Comment> commentsReturn=new ArrayList<Comment>();
//		Comment commentNull=null;
//		commentsReturn.add(commentNull);
//		when(commentJPARepository.saveAndFlush(commentNull)).thenReturn(commentNull);
//		when(commentJPARepository.findAll()).thenReturn(commentsReturn);
//		assertNull(commentService.addComment(commentNull));
//	}
//	
//	@Test
//	@DisplayName("Check for get all successful")
//	public void testGetAllComments() throws Exception {
//		List<Comment> commentsList=new ArrayList<>();
//		commentsList.add(comment3);
//		commentsList.add(comment4);
//		when(commentJPARepository.findAll()).thenReturn(commentsList);
//		assertEquals(commentsList, commentService.findAllComments());
//		
//	}
//	
//	@Test
//	@DisplayName("Check for get comments by id successful")
//	public void testGetCommentsById( ) throws IdNotFoundException
//	{
//		when(commentJPARepository.existsById(101)).thenReturn(true);
//		when(commentJPARepository.findById(101)).thenReturn(Optional.of(comment1));
//		assertEquals(comment1, commentService.findCommentsById(101));
//	}
//	
//	@Test
//	@DisplayName("Check for deletion successful")
//	public void testDeleteMethod() throws IdNotFoundException
//	{
//		when(commentJPARepository.findById(101)).thenReturn(Optional.of(comment1));
//		List<Comment> comments=commentService.deleteCommentById(101);
//		List<Comment> comments1=new ArrayList<Comment>();
//		assertEquals(comments,comments1);
//	}
//	
//	@Test
//	@DisplayName("check for get Comments By id failure")
//	public void testGetByIsNull() throws CommunityIdNotFoundException
//	{
//		when(commentJPARepository.existsById(103)).thenReturn(false);
//		when(commentJPARepository.findById(101)).thenReturn(Optional.of(comment1));
//		assertThrows(IdNotFoundException.class,()-> commentService.findCommentsById(103));
//	}
//	
//	@Test
//	@DisplayName("Check update successful")
//	public void testUpdate() throws IdNotFoundException
//	{
//		List<Comment> comments=new ArrayList<Comment>();
//		comments.add(comment1);
//		comments.get(0).setCommentDescription("Oh..good");
//		when(commentJPARepository.findAll()).thenReturn(comments);
//		when(commentJPARepository.existsById(101)).thenReturn(true);
//		when(commentJPARepository.save(comment1)).thenReturn(comment1);
//		List<Comment> updateComment=commentService.updatecomment(comment1);
//		assertEquals(updateComment,comments);
//	}
//
//	@Test
//	@DisplayName("Check for update failure")
//	public void testUpdateFailure() 
//	{
//		
//		when(commentJPARepository.existsById(101)).thenReturn(false);
//		assertThrows(IdNotFoundException.class,()->commentService.updatecomment(comment1));
//	}
//}
