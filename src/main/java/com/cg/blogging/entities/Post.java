package com.cg.blogging.entities;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table(name = "Post_Temp")
@JsonIgnoreProperties({"hibrernateLazyInitialzer","handler","createdBy"})
public class Post {
	
	@Id
	@Column(name="post_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int postId;

	@NotNull
	@Size(min=5,max=30,message="please enter  between 5 to 30 characters ")
	@Column(name = "title")
	private String title;

	@ManyToOne
	@JoinColumn(name="created_by")
	private Blogger createdBy;
	
	
	@Column(name = "content")
	@Enumerated
	private PostType content;

	@Column(name = "created_date_time")
	private LocalDateTime createdDateTime;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
	private List<Comment> comments = new ArrayList<>();

	@Column(name = "votes")
	private int votes;

	@Column(name = "vote_up")
	private boolean voteUp;

	@Column(name = "not_safe_for_work")
	private boolean notSafeForWork;

	@Column(name = "spoiler")
	private boolean spoiler;

	@Column(name = "original_content")
	private boolean originalContent;

	@Column(name = "flair")
	private String flair;
	
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name="Post_community")
	private Community community;
	
//	Constructor
	public Post(int postId, String title, Blogger createdBy, PostType content,
			LocalDateTime createdDateTime, List<Comment> comments, int votes, boolean voteUp, boolean notSafeForWork,
			boolean spoiler, boolean originalContent, String flair, Community community) {
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

	public Post() {
		
	}
	
	
public Post(@Size(min = 5, max = 30, message = "please enter  between 5 to 30 characters ") String title,
			Blogger createdBy, PostType content, LocalDateTime createdDateTime, List<Comment> comments, int votes,
			boolean voteUp, boolean notSafeForWork, boolean spoiler, boolean originalContent, String flair,
			Community community) {
		super();
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

//	Getters and Setters method
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
	
//	To String method
	@Override
	public String toString() {
		return "Post [postId=" + postId + ", title=" + title + ", createdBy=" + createdBy + ", content=" + content
				+ ", createdDateTime=" + createdDateTime + ", comments=" + comments + ", votes=" + votes + ", voteUp="
				+ voteUp + ", notSafeForWork=" + notSafeForWork + ", spoiler=" + spoiler + ", originalContent="
				+ originalContent + ", flair=" + flair + ", community=" + community + "]";
	}
	
//	HashCode method
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + postId;
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
		Post other = (Post) obj;
		if (postId != other.postId)
			return false;
		return true;
	}
	

	
	
}