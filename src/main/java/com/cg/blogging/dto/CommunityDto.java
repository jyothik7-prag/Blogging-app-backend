package com.cg.blogging.dto;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.cg.blogging.entities.Blogger;

public class CommunityDto
{
	
	private int communityId;
	

	private String communityDescription;

	private int totalMembers;
	
	private int onlineMembers;
	

	private LocalDate createdOn;
	

	private List<String> postRulesAllowed;
	

	private List<String> postRulesDisallowed;
	
	private List<String> banningPolicy;
	
	

	private List<String> flairs;
	
	
	
	private List<Blogger> blogger;



	public CommunityDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public CommunityDto(int communityId, String communityDescription, int totalMembers, int onlineMembers,
			LocalDate createdOn, List<String> postRulesAllowed, List<String> postRulesDisallowed,
			List<String> banningPolicy, List<String> flairs, List<Blogger> blogger) {
		super();
		this.communityId = communityId;
		this.communityDescription = communityDescription;
		this.totalMembers = totalMembers;
		this.onlineMembers = onlineMembers;
		this.createdOn = createdOn;
		this.postRulesAllowed = postRulesAllowed;
		this.postRulesDisallowed = postRulesDisallowed;
		this.banningPolicy = banningPolicy;
		this.flairs = flairs;
		this.blogger = blogger;
	}



	public int getCommunityId() {
		return communityId;
	}



	public void setCommunityId(int communityId) {
		this.communityId = communityId;
	}



	public String getCommunityDescription() {
		return communityDescription;
	}



	public void setCommunityDescription(String communityDescription) {
		this.communityDescription = communityDescription;
	}



	public int getTotalMembers() {
		return totalMembers;
	}



	public void setTotalMembers(int totalMembers) {
		this.totalMembers = totalMembers;
	}



	public int getOnlineMembers() {
		return onlineMembers;
	}



	public void setOnlineMembers(int onlineMembers) {
		this.onlineMembers = onlineMembers;
	}



	public LocalDate getCreatedOn() {
		return createdOn;
	}



	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}



	public List<String> getPostRulesAllowed() {
		return postRulesAllowed;
	}



	public void setPostRulesAllowed(List<String> postRulesAllowed) {
		this.postRulesAllowed = postRulesAllowed;
	}



	public List<String> getPostRulesDisallowed() {
		return postRulesDisallowed;
	}



	public void setPostRulesDisallowed(List<String> postRulesDisallowed) {
		this.postRulesDisallowed = postRulesDisallowed;
	}



	public List<String> getBanningPolicy() {
		return banningPolicy;
	}



	public void setBanningPolicy(List<String> banningPolicy) {
		this.banningPolicy = banningPolicy;
	}



	public List<String> getFlairs() {
		return flairs;
	}



	public void setFlairs(List<String> flairs) {
		this.flairs = flairs;
	}



	public List<Blogger> getBlogger() {
		return blogger;
	}



	public void setBlogger(List<Blogger> blogger) {
		this.blogger = blogger;
	}
	
	
}
