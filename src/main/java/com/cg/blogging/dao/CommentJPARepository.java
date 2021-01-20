package com.cg.blogging.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cg.blogging.entities.Comment;

@Repository
public interface CommentJPARepository extends JpaRepository<Comment,Integer>{
//	@Query(value = "select comment from Comments_temp comment where comment.post_comment=?1",nativeQuery = true)
//	public List<Comment> searchCommentsByPost(int post_id);
	
	@Query(value= "select c from Comment c where c.post.postId=?1")
	public List<Comment> searchCommentsByPost(int post_id);
	
}
