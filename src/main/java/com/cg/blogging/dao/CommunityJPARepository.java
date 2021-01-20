package com.cg.blogging.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.blogging.entities.Community;

@Repository
public interface CommunityJPARepository extends JpaRepository<Community,Integer>{
	
//	@Query(value = "select * from community_temp  where community_description LIKE %?1%",nativeQuery = true)
//	public List<Community> getCommunitiesByString(String str);
	
}
