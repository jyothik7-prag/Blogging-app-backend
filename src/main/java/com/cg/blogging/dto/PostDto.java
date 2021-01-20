package com.cg.blogging.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Comment;
import com.cg.blogging.entities.Community;
import com.cg.blogging.entities.PostType;
import com.sun.istack.NotNull;

public class PostDto 
{

	private int postId;


	private String title;

	private Blogger createdBy;
	
	private PostType content;

	private LocalDateTime createdDateTime;

	private List<Comment> comments = new ArrayList<>();

	private int votes;

	private boolean voteUp;

	private boolean notSafeForWork;

	private boolean spoiler;

	
	private boolean originalContent;


	private String flair;
	
	
	private Community community;


	public PostDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PostDto(int postId, String title, Blogger createdBy, PostType content, LocalDateTime createdDateTime,
			List<Comment> comments, int votes, boolean voteUp, boolean notSafeForWork, boolean spoiler,
			boolean originalContent, String flair, Community community) {
		super();
		this.postId = postId;
		this.title = title;
		this.createdBy = createdBy;
		this.content = content;
		this.createdDateTime = createdDateTime;
		this.comments = comments;
		this.votes = votes;
		this.voteUp = voteUp;
		this.notSafeForWork = notSafeForWork;
		this.spoiler = spoiler;
		this.originalContent = originalContent;
		this.flair = flair;
		this.community = community;
	}


	public int getPostId() {
		return postId;
	}


	public void setPostId(int postId) {
		this.postId = postId;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Blogger getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(Blogger createdBy) {
		this.createdBy = createdBy;
	}


	public PostType getContent() {
		return content;
	}


	public void setContent(PostType content) {
		this.content = content;
	}


	public LocalDateTime getCreatedDateTime() {
		return createdDateTime;
	}


	public void setCreatedDateTime(LocalDateTime createdDateTime) {
		this.createdDateTime = createdDateTime;
	}


	public List<Comment> getComments() {
		return comments;
	}


	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}


	public int getVotes() {
		return votes;
	}


	public void setVotes(int votes) {
		this.votes = votes;
	}


	public boolean isVoteUp() {
		return voteUp;
	}


	public void setVoteUp(boolean voteUp) {
		this.voteUp = voteUp;
	}


	public boolean isNotSafeForWork() {
		return notSafeForWork;
	}


	public void setNotSafeForWork(boolean notSafeForWork) {
		this.notSafeForWork = notSafeForWork;
	}


	public boolean isSpoiler() {
		return spoiler;
	}


	public void setSpoiler(boolean spoiler) {
		this.spoiler = spoiler;
	}


	public boolean isOriginalContent() {
		return originalContent;
	}


	public void setOriginalContent(boolean originalContent) {
		this.originalContent = originalContent;
	}


	public String getFlair() {
		return flair;
	}


	public void setFlair(String flair) {
		this.flair = flair;
	}


	public Community getCommunity() {
		return community;
	}


	public void setCommunity(Community community) {
		this.community = community;
	}
	
	

}
