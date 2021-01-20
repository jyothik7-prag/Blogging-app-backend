//package com.cg.blogging.application;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.*;
//
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//
//import com.cg.blogging.dao.UserJPARepository;
//import com.cg.blogging.entities.User;
//import com.cg.blogging.exception.IdNotFoundException;
//import com.cg.blogging.service.UserServiceImpl;
//
//@SpringBootTest
//
// public class UserServiceTest {
//	
//	@MockBean
//	private UserJPARepository userJPARepository;
//	
//	@Autowired
//	private UserServiceImpl userService;
//	
//	User user2=new User(121,"Hello1","Blogger");
//	User user1=new User(11,"Hlo1","Blogger");
//
//	@Test
//	public void addNewUserTest() throws IdNotFoundException
//	{
//		List<User> users=new ArrayList<User>();
//		users.add(user2);
//	    when(userJPARepository.findAll()).thenReturn(users);
//		when(userJPARepository.saveAndFlush(user2)).thenReturn(user2);
//		assertEquals(users.size(),userService.addNewUser(user2).size());
//	}
//	
//	
//	@Test
//	@DisplayName("signIn")
//	public void succesfulSignIn() {
//		
//		User user1=new User(11,"Hlo1","Blogger");
//		User user2=new User(121,"Hello1","Blogger");
//	      Mockito.doReturn(Optional.of(user2)).when(userJPARepository).findById(user2.getUserId());
//						User  retUser=userService.signIn(user2);
//						assertSame(user2,retUser);
//					}	 		
//	
//	
//	@Test
//	@DisplayName("signOut")
//	public void usernotSignedOut() throws IdNotFoundException {
//		User user1=new User(11,"Hlo1","Blogger");
//		Mockito.when(userJPARepository.saveAndFlush(user1)).thenReturn(user1);
//		User updatelist=null;
//		try {
//			updatelist=userService.signOut(user1);
//	   } catch (IdNotFoundException e) {
//	       // TODO Auto-generated catch block
//		   assertEquals(e.getMessage(),"Id not found");
//	       //e.printStackTrace();
//	   }
//		
//	}
//}