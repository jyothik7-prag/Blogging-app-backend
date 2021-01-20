package com.cg.blogging.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Post;

public class CommentDto {
	
	private int commentId;
	

	private String commentDescription;
	
	
	private int votes;


	private Blogger blogger;
	

	private Post post;
	
	private boolean voteUp;
	
	
	

	public CommentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public CommentDto(int commentId, String commentDescription, int votes, Blogger blogger, Post post, boolean voteUp) {
		super();
		this.commentId = commentId;
		this.commentDescription = commentDescription;
		this.votes = votes;
		this.blogger = blogger;
		this.post = post;
		this.voteUp = voteUp;
	}



	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getCommentDescription() {
		return commentDescription;
	}

	public void setCommentDescription(String commentDescription) {
		this.commentDescription = commentDescription;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	public Blogger getBlogger() {
		return blogger;
	}

	public void setBlogger(Blogger blogger) {
		this.blogger = blogger;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public boolean isVoteUp() {
		return voteUp;
	}

	public void setVoteUp(boolean voteUp) {
		this.voteUp = voteUp;
	}
	
	


}
