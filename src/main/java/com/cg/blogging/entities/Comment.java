package com.cg.blogging.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Comments_Temp")
@JsonIgnoreProperties({"hibrernateLazyInitialzer","handler","post"})
public class Comment {
	
	@NotNull
	@Id
	@Column(name = "comment_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int commentId;
	

	@Column(name = "comment_description")
	private String commentDescription;
	
	@Column(name = "votes")
	private int votes;

	@ManyToOne
	@JoinColumn(name="Blogger_comment")
	private Blogger blogger;
	
	@ManyToOne
	@JoinColumn(name="Post_comment")
	private Post post;
	
	@Column(name = "voteUp")
	private boolean voteUp;
		
// 	Constructor
	public Comment(int commentId, String commentDescription, int votes, Blogger blogger, Post post, boolean voteUp)
	{
		super();
		this.commentId = commentId;
		this.commentDescription = commentDescription;
		this.votes = votes;
		this.blogger = blogger;
		this.post = post;
		this.voteUp = voteUp;
	}
	
	

	public Comment(String commentDescription, int votes, Blogger blogger, Post post, boolean voteUp) {
		super();
		this.commentDescription = commentDescription;
		this.votes = votes;
		this.blogger = blogger;
		this.post = post;
		this.voteUp = voteUp;
	}



	public Comment()
	{
		super();
	}

//	Getters and Setters method
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
	
	

@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", commentDescription=" + commentDescription + ", votes=" + votes
				+ ", blogger=" + blogger + ", post=" + post + ", voteUp=" + voteUp + "]";
	}



	// HashCode method
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + commentId;
		return result;
	}
	
	

//	Equals method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comment other = (Comment) obj;
		if (commentId != other.commentId)
			return false;
		return true;
	}
}
