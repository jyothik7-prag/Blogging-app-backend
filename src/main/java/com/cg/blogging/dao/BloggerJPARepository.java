package com.cg.blogging.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.blogging.dto.BloggerDto;
import com.cg.blogging.entities.Blogger;

@Repository
public interface BloggerJPARepository extends JpaRepository<Blogger,Integer>
{
	@Query(value="select b from Blogger b where b.user.role=?1")
	public Blogger retriveBloggerThroughEmail(String role);
	

}
