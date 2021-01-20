package com.cg.blogging.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.blogging.entities.Post;

@Repository
public interface PostJPARepository extends JpaRepository<Post,Integer>{
	@Query(value="select * from post_temp where title LIKE %?1%",nativeQuery=true )
	public List<Post> getPostBySearchString(String searchStr);
	

}