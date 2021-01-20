//package com.cg.blogging.application;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.aspectj.lang.annotation.Before;
//import org.assertj.core.util.Arrays;
//import org.hibernate.query.criteria.internal.expression.SearchedCaseExpression.WhenClause;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.event.annotation.BeforeTestClass;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.*;
//import com.cg.blogging.dao.CommunityJPARepository;
//import com.cg.blogging.entities.Community;
//import com.cg.blogging.exception.CommunityIdNotFoundException;
//import com.cg.blogging.exception.IdNotFoundException;
//import com.cg.blogging.exception.NullCommunityException;
//import com.cg.blogging.service.CommunityService;
//import com.cg.blogging.service.CommunityServiceImpl;
//
//@SpringBootTest
//
//public class CommunityServiceTest {
//	
//	@MockBean
//	private CommunityJPARepository communityJPARepository;
//	
//	@Autowired
//	private CommunityServiceImpl communityService;
//
//	Community community2=new Community("Angular",20, 10, LocalDate.now(), null, null, null, null);
//	Community community1=new Community(101,"Angular12",20, 10, LocalDate.now(), null, null, null, null);
//	Community community3=new Community(102,"Angular12",20, 10, LocalDate.now(), null, null, null, null);
//	Community community4=new Community(103,"Angular12",20, 10, LocalDate.now(), null, null, null, null);
//	
//	@Test
//	@DisplayName("Check for get by id successful")
//	public void testCommunityById() throws IdNotFoundException, CommunityIdNotFoundException
//	{
//		when(communityJPARepository.existsById(101)).thenReturn(true);
//		when(communityJPARepository.findById(101)).thenReturn(Optional.of(community1));
//		assertEquals(community1, communityService.findCommunityById(101));
//	}
//	
//	@Test
//	@DisplayName("Check for addition successful")
//	public void testAddCommunity() throws IdNotFoundException, NullCommunityException
//	{
//		List<Community> community=new ArrayList<Community>();
//		community.add(community2);
//		when(communityJPARepository.findAll()).thenReturn(community);
//		when(communityJPARepository.saveAndFlush(community2)).thenReturn(community2);
//		assertEquals(community.size(),communityService.addCommunity(community2).size());
//	}
//	
//	@Test
//	@DisplayName("Check for updation successful")
//	public void testUpdateCommunityTest() throws CommunityIdNotFoundException
//	{
//		List<Community> community=new ArrayList<Community>();
//		community.add(community1);
//		community.get(0).setCommunityDescription("Ang");
//		when(communityJPARepository.findAll()).thenReturn(community);
//		when(communityJPARepository.existsById(101)).thenReturn(true);
//		when(communityJPARepository.save(community1)).thenReturn(community1);
//		List<Community> updateCommunity=communityService.updateCommunity(community1);
//		System.out.println(updateCommunity+"returned value");
//		assertEquals(updateCommunity,community);
//	}
//	
//	@Test
//	@DisplayName("Check for deletion successful")
//	public void testDeleteCommunityByIdTest() throws IdNotFoundException, CommunityIdNotFoundException
//	{
//		when(communityJPARepository.findById(101)).thenReturn(Optional.of(community1));
//		List<Community> community=communityService.deleteCommunityById(101);
//		List<Community> communities=new ArrayList<Community>();
//		assertEquals(community,communities);
//	}
//	
//	@Test
//	@DisplayName("Check for get all successful")
//	public void testGetAllCommunities()
//	{
//		List<Community> communities=new ArrayList<Community>();
//		communities.add(community3);
//		communities.add(community4);
//		when(communityJPARepository.findAll()).thenReturn(communities);
//		assertEquals(communities,communityService.getAllCommunities());
//	}
//	
//	@Test
//	@DisplayName("Check for get by id failure")
//	public void testGetByIsNull() throws CommunityIdNotFoundException
//	{
//		when(communityJPARepository.existsById(103)).thenReturn(false);
//		when(communityJPARepository.findById(101)).thenReturn(Optional.of(community1));
//		assertThrows(CommunityIdNotFoundException.class,()-> communityService.findCommunityById(103));
//	}
//	
//	@Test
//	@DisplayName("Check for adding Null")
//	public void testAddNull()
//	{
//		when(communityJPARepository.saveAndFlush(null)).thenReturn(null);
//		assertThrows(NullCommunityException.class,()-> communityService.addCommunity(null));
//	}
//	
//	@Test
//	@DisplayName("Check for update failure")
//	public void testUpdateFailure() 
//	{
//		
//		when(communityJPARepository.existsById(101)).thenReturn(false);
//		assertThrows(CommunityIdNotFoundException.class,()->communityService.updateCommunity(community1));
//	}
//	
//	@Test
//	@DisplayName("Check size of get all")
//	public void testSizeGetAll()
//	{
//		List<Community> communities=new ArrayList<Community>();
//		communities.add(community3);
//		communities.add(community4);
//		when(communityJPARepository.findAll()).thenReturn(communities);
//		assertEquals(communities.size(),communityService.getAllCommunities().size());
//	}
//}
