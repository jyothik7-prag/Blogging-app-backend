package com.cg.blogging.entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedBy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Blogger_Temp")
@JsonIgnoreProperties({"hibrernateLazyInitialzer","handler","posts","comment"})
public class Blogger{
	
	@Id
	@Column(name="blogger_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bloggerId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="user_idd")
	private User user;
	
	@Size(min = 3, max = 10, message = "bloggerName should be between 3 and 10")
	@NotEmpty(message = "blogger name has to be mentioned. It should not be null")
	@Column(name = "blogger_name")
	private String bloggerName;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "createdBy")
	private List<Post> posts = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "blogger")
	private List<Comment> comment = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "UPVOTES", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "UPVOTES")
	private List<Post> upvoted = new ArrayList<>();

	@ElementCollection
	@CollectionTable(name = "DOWNVOTES", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "DOWNVOTES")
	private List<Post> downvoted = new ArrayList<>();
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Community> communities;

	public Blogger(int bloggerId, User user,
			@Size(min = 3, max = 10, message = "bloggerName should be between 3 and 10") @NotEmpty(message = "blogger name has to be mentioned. It should not be null") String bloggerName,
			List<Post> posts, List<Comment> comment, List<Post> upvoted, List<Post> downvoted,
			List<Community> communities) {
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
	
	

	public Blogger() {
		super();
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



	@Override
	public String toString() {
		return "Blogger [bloggerId=" + bloggerId + ", user=" + user + ", bloggerName=" + bloggerName + ", posts="
				+ posts + ", comment=" + comment + ", upvoted=" + upvoted + ", downvoted=" + downvoted
				+ ", communities=" + communities + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bloggerId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Blogger other = (Blogger) obj;
		if (bloggerId != other.bloggerId)
			return false;
		return true;
	}

}