package com.cg.blogging.service;

import java.util.List;
import java.util.Optional;

import com.cg.blogging.dto.CommunityDto;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Community;
import com.cg.blogging.exception.CommunityIdNotFoundException;
import com.cg.blogging.exception.IdNotFoundException;
import com.cg.blogging.exception.NullCommunityException;

public interface CommunityService 
{
	
	public CommunityDto addCommunity(CommunityDto communityDto) throws NullCommunityException;
	public List<CommunityDto> deleteCommunityById(int id) throws CommunityIdNotFoundException;
	public CommunityDto updateCommunity(CommunityDto communityDto) throws CommunityIdNotFoundException;
	public CommunityDto findCommunityById(int id) throws CommunityIdNotFoundException;
	public List<CommunityDto> getAllCommunities();
}
