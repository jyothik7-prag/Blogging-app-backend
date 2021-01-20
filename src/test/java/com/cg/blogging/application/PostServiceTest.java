//package com.cg.blogging.application;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
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
//import com.cg.blogging.dao.PostJPARepository;
//import com.cg.blogging.entities.Post;
//import com.cg.blogging.exception.IdNotFoundException;
//import com.cg.blogging.service.PostServiceImpl;
//import static org.mockito.Mockito.*;
//
//@SpringBootTest
//public class PostServiceTest {
//	
//	@MockBean
//	private PostJPARepository postJPARepository;
//	
//	@Autowired
//	private PostServiceImpl postService;
//	
//	
//	Post post2= new Post(7163,"my story",null,null,LocalDateTime.now(),null,12,false,false,true,true,"bad",null);
//	Post post1= new Post("my story is good",null,null,LocalDateTime.now(),null,12,false,false,true,true,"bad",null);
//	
//	
//	
//	@Test
//	@DisplayName("successfully added post")
//	public void addPostTest() throws IdNotFoundException {
//		List<Post> post=new ArrayList<Post>();
//		post.add(post2);
//		when(postJPARepository.findAll()).thenReturn(post);
//		when(postJPARepository.saveAndFlush(post2)).thenReturn(post2);
//		assertEquals(post.size(),postService.addPost(post2).size());
//	}
//
//	
//	@Test
//	@DisplayName("successfully update the post")
//	public void updatePostTest() throws IdNotFoundException {
//	
//		List<Post> post=new ArrayList<Post>();
//		post.add(post2);
//		post.get(0).setTitle("mystory");
//		when(postJPARepository.findAll()).thenReturn(post);
//		when(postJPARepository.existsById(7163)).thenReturn(true);
//		when(postJPARepository.save(post2)).thenReturn(post2);
//		List<Post> updatePost=postService.updatePost(post2);
//		assertEquals(updatePost,post);
//	}
//
//	@Test
//	@DisplayName("successfully delete  post")
//	public void  deletePostTest() throws IdNotFoundException {
//		when(postJPARepository.findById(7163)).thenReturn(Optional.of(post2));
//		assertEquals(post2,postService.deletePost(7163));
//		
//		
//	}
//	@Test
//	@DisplayName(" add post")
//	public void addPostTestException() {
//			List<Post> posts= new ArrayList<Post>();
//			Post post=null;
//			posts.add(post);
//			when(postJPARepository.findAll()).thenReturn(posts);
//			when(postJPARepository.save(post)).thenReturn(post);
//		assertThrows(IdNotFoundException.class,()->postService.addPost(post));
//	}
//	@Test
//	@DisplayName("After adding returns size")
//	public void addPostsizeTest() throws IdNotFoundException {
//		List<Post>posts= new ArrayList<Post>();
//		posts.add(post2);
//		when(postJPARepository.findAll()).thenReturn(posts);
//		when(postJPARepository.saveAndFlush(post2)).thenReturn(post2);
//		assertEquals(posts.size(),postService.addPost(post2).size());
//		
//		
//	}
//	@Test
//	@DisplayName(" displays the size of all posts")
//	public void getAllPostsSizeTest() {
//		List<Post> posts= new ArrayList<Post>();
//		when(postJPARepository.findAll()).thenReturn(posts);
//		assertEquals(posts.size(),postService.viewAllPosts().size());
//		
//	}
//	@Test
//	@DisplayName("successfully displays all posts")
//	public void getAllPostsTest() {
//		List<Post> posts=new ArrayList<Post>();
//		posts.add(post2);
//		when(postJPARepository.findAll()).thenReturn(posts);
//		List<Post> viewPosts=postService.viewAllPosts();
//		assertEquals(posts,viewPosts);
//		
//		
//	}
//	@Test
//	@DisplayName("After updatng returns size")
//	public void updatePostSizeTest()throws IdNotFoundException{
//		List<Post> posts=new ArrayList<Post>();
//		posts.add(post2);
//		posts.get(0).setTitle("mystory");
//		when(postJPARepository.findAll()).thenReturn(posts);
//		when(postJPARepository.existsById(7163)).thenReturn(true);
//		when(postJPARepository.save(post2)).thenReturn(post2);
//		List<Post> updatePost=postService.updatePost(post2);
//		assertEquals(updatePost.size(),posts.size());
//		
//	}
//	
//		
//		
//	}