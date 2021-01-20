package com.cg.blogging.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.User;

@Repository
public interface UserJPARepository extends JpaRepository<User,Integer>{

	
	@Query(value="select u from User u where u.role=?1")
	public User findByEmail(String role);
	
	@Query(value="select b from Blogger b where b.user.role=?1")
	public Blogger findBloggerByEmail(String role);
	

}
