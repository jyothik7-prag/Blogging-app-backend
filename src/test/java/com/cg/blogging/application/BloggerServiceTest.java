//package com.cg.blogging.application;
//
//import static org.junit.jupiter.api.Assertions.*;
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
//import com.cg.blogging.dao.BloggerJPARepository;
//import com.cg.blogging.entities.Blogger;
//import com.cg.blogging.exception.BloggerIdNotFoundException;
//import com.cg.blogging.exception.NullBloggerException;
//import com.cg.blogging.service.BloggerServiceImpl;
//
//@SpringBootTest
//public class BloggerServiceTest {
//	@MockBean
//	private BloggerJPARepository bloggerJPARepository;
//
////	@Autowired
////	private BloggerServiceImpl bloggerServiceImpl;
////	Blogger blogger1 = new Blogger(1, "hiii", "blogger", "jyothi", null, null, null, null, null);
////	Blogger blogger2 = new Blogger("welcome", "blogger", "lalitha", null, null, null, null, null);
//	
//	@Test
//	@DisplayName("displays the size of all bloggers")
//	public void getAllBloggersSizeTest() {
//		List<Blogger> bloggers = new ArrayList<Blogger>();
//		when(bloggerJPARepository.findAll()).thenReturn(bloggers);
//		assertEquals(bloggers.size(), bloggerServiceImpl.viewAllBloggers().size());
//	}
//
//	@Test
//	@DisplayName("After adding returns size")
//	public void addBloggerSizeTest() throws NullBloggerException {
//		List<Blogger> bloggers = new ArrayList<Blogger>();
//		bloggers.add(blogger2);
//		when(bloggerJPARepository.findAll()).thenReturn(bloggers);
//		when(bloggerJPARepository.saveAndFlush(blogger2)).thenReturn(blogger2);
//		assertEquals(bloggers.size(), bloggerServiceImpl.addBlogger(blogger2).size());
//	}
//
//	@Test
//	@DisplayName("After deleting returns size")
//	public void deleteBloggerByIdSizeTest() throws BloggerIdNotFoundException {
//		when(bloggerJPARepository.findById(1)).thenReturn(Optional.of(blogger1));
//		List<Blogger> blogger = bloggerServiceImpl.deleteBloggerById(1);
//		List<Blogger> bloggers = new ArrayList<Blogger>();
//		assertEquals(bloggers.size(), blogger.size());
//	}
//
//	
//	@Test
//	@DisplayName("successfully displays all bloggers")
//	public void getAllBloggersTest() {
//		List<Blogger> bloggers = new ArrayList<Blogger>();
//		bloggers.add(blogger2);
//		when(bloggerJPARepository.findAll()).thenReturn(bloggers);
//		List<Blogger> viewBloggers = bloggerServiceImpl.viewAllBloggers();
//		System.out.println("all bloggers ="+bloggers);
//		assertEquals(bloggers, viewBloggers);
//	}
//
//	@Test
//	@DisplayName("successfully displays the blogger by Id")
//	public void getBloggerByIdTest() throws BloggerIdNotFoundException {
//		when(bloggerJPARepository.existsById(1)).thenReturn(true);
//		when(bloggerJPARepository.findById(1)).thenReturn(Optional.of(blogger1));
//		assertEquals(blogger1, bloggerServiceImpl.findBloggerById(1));
//	}
//
//	@Test
//	@DisplayName("successfully added the blogger")
//	public void addBloggerTest() throws NullBloggerException {
//		List<Blogger> bloggers = new ArrayList<Blogger>();
//		bloggers.add(blogger1);
//		when(bloggerJPARepository.findAll()).thenReturn(bloggers);
//		when(bloggerJPARepository.save(blogger1)).thenReturn(blogger1);
//		List<Blogger> addBlogger = bloggerServiceImpl.addBlogger(blogger1);
//		// System.out.println(updateBlogger+"returned value");
//		assertEquals(addBlogger, bloggers);
//	}
//
//	
//	@Test
//	@DisplayName("successfully deleted the blogger by Id")
//	public void deleteBloggerByIdTest() throws BloggerIdNotFoundException {
//		when(bloggerJPARepository.findById(1)).thenReturn(Optional.of(blogger1));
//		List<Blogger> blogger = bloggerServiceImpl.deleteBloggerById(1);
//		List<Blogger> bloggers = new ArrayList<Blogger>();
//		assertEquals(blogger, bloggers);
//	}
//
//	
//	@Test
//	@DisplayName("checked the exception for retrieving the blogger using Id")
//	public void getBloggerByIdExceptionTest() {
//		when(bloggerJPARepository.existsById(5)).thenReturn(false);
//		when(bloggerJPARepository.findById(5)).thenReturn(null);
//		assertThrows(BloggerIdNotFoundException.class, () -> bloggerServiceImpl.findBloggerById(5));
//	}
//	
//	@Test
//	@DisplayName("checked the exception for adding the blogger")
//	public void addBloggerExceptionTest() {
//		List<Blogger> bloggers = new ArrayList<Blogger>();
//		Blogger blogger = null;
//		bloggers.add(blogger);
//		when(bloggerJPARepository.findAll()).thenReturn(bloggers);
//		when(bloggerJPARepository.save(blogger)).thenReturn(blogger);
//		assertThrows(NullBloggerException.class, () -> bloggerServiceImpl.addBlogger(blogger));
//	}
//	
//}
//
//		
