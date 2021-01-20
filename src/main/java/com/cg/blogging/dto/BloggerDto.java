package com.cg.blogging.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.cg.blogging.entities.Comment;
import com.cg.blogging.entities.Community;
import com.cg.blogging.entities.Post;
import com.cg.blogging.entities.User;

public class BloggerDto {
	
	private int bloggerId;
	
	private User user;
	
	private String bloggerName;

	private List<Post> posts = new ArrayList<>();

	private List<Comment> comment = new ArrayList<>();

	private List<Post> upvoted = new ArrayList<>();
	
	private List<Post> downvoted = new ArrayList<>();
	
	private List<Community> communities;

	public BloggerDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BloggerDto(int bloggerId, User user, String bloggerName, List<Post> posts, List<Comment> comment,
			List<Post> upvoted, List<Post> downvoted, List<Community> communities) {
		super();
		this.bloggerId = bloggerId;
		this.user = user;
		this.bloggerName = bloggerName;
		this.posts = posts;
		this.comment = comment;
		this.upvoted = upvoted;
		this.downvoted = downvoted;
		this.communities = communities;
	}

	public int getBloggerId() {
		return bloggerId;
	}

	public void setBloggerId(int bloggerId) {
		this.bloggerId = bloggerId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBloggerName() {
		return bloggerName;
	}

	public void setBloggerName(String bloggerName) {
		this.bloggerName = bloggerName;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Comment> getComment() {
		return comment;
	}

	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}

	public List<Post> getUpvoted() {
		return upvoted;
	}

	public void setUpvoted(List<Post> upvoted) {
		this.upvoted = upvoted;
	}

	public List<Post> getDownvoted() {
		return downvoted;
	}

	public void setDownvoted(List<Post> downvoted) {
		this.downvoted = downvoted;
	}

	public List<Community> getCommunities() {
		return communities;
	}

	public void setCommunities(List<Community> communities) {
		this.communities = communities;
	}

	

}
