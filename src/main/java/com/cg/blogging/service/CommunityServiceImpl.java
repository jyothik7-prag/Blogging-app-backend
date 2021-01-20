package com.cg.blogging.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.blogging.dao.CommunityJPARepository;
import com.cg.blogging.dto.CommunityDto;
import com.cg.blogging.entities.Blogger;
import com.cg.blogging.entities.Community;
import com.cg.blogging.exception.CommunityIdNotFoundException;
import com.cg.blogging.exception.IdNotFoundException;
import com.cg.blogging.exception.NullCommunityException;
import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;
//import com.sun.tools.sjavac.Log;

@Service
public class CommunityServiceImpl implements CommunityService {
	static Logger log = Logger.getLogger(CommunityServiceImpl.class.getName());

	@Autowired
	private CommunityJPARepository communityJPARepository;
	
	public Community convertDtoToEntity(CommunityDto communityDto)
	{
		Community community=new Community();
		
		community.setBanningPolicy(communityDto.getBanningPolicy());
		community.setBlogger(communityDto.getBlogger());
		community.setCommunityDescription(communityDto.getCommunityDescription());
		community.setCommunityId(communityDto.getCommunityId());
		community.setCreatedOn(communityDto.getCreatedOn());
		community.setFlairs(communityDto.getFlairs());
		community.setOnlineMembers(communityDto.getOnlineMembers());
		community.setPostRulesAllowed(communityDto.getPostRulesAllowed());
		community.setPostRulesDisallowed(communityDto.getPostRulesDisallowed());
		community.setTotalMembers(communityDto.getTotalMembers());
		
		return community;
	}
	
	public CommunityDto convertEntityToDto(Community community)
	{
		CommunityDto communityDto=new CommunityDto();
		
		communityDto.setBanningPolicy(community.getBanningPolicy());
		communityDto.setBlogger(community.getBlogger());
		communityDto.setCommunityDescription(community.getCommunityDescription());
		communityDto.setCommunityId(community.getCommunityId());
		communityDto.setCreatedOn(community.getCreatedOn());
		communityDto.setFlairs(community.getFlairs());
		communityDto.setOnlineMembers(community.getOnlineMembers());
		communityDto.setPostRulesAllowed(community.getPostRulesAllowed());
		communityDto.setPostRulesDisallowed(community.getPostRulesDisallowed());
		communityDto.setTotalMembers(community.getTotalMembers());
		
		return communityDto;
	}

	@Override
	public CommunityDto addCommunity(CommunityDto communityDto) throws NullCommunityException {
		Community community=convertDtoToEntity(communityDto);
		log.info("Service layer-add method-entry");
		if (community == null) 
		{
			log.warn("passed object is null");
			throw new NullCommunityException("cannot add community because the object passed is null!");
		} 
		else 
		{
			community=communityJPARepository.saveAndFlush(community);
			communityDto=convertEntityToDto(community);
			log.info("Service layer-find_community_by_ID method-exit");
			return communityDto;
		}
	}

	@Override
	public List<CommunityDto> deleteCommunityById(int id) throws CommunityIdNotFoundException {
		log.info("Service layer-delete_community_by_Id method-entry");
		Optional<Community> communityNull = Optional.empty();
		if (communityJPARepository.findById(id) != communityNull) {
			communityJPARepository.deleteById(id);
			log.info("Service layer-delete_community_by_ID method-exit");
			List<Community> community= communityJPARepository.findAll();
			List<CommunityDto> communityDto=new ArrayList<CommunityDto>();
			for(Community com:community)
			{
				communityDto.add(convertEntityToDto(com));
			}
			return communityDto;
			
		} else {
			log.warn("Service layer-delete_community_by_ID method-exception");
			throw new CommunityIdNotFoundException("cannot delete community because Id " + id + " is not found!");
		}
	}

	@Override
	public CommunityDto updateCommunity(CommunityDto communityDto) throws CommunityIdNotFoundException {
		log.info("Service layer-update method-entry");
		Community community=convertDtoToEntity(communityDto);
		if (communityJPARepository.existsById(community.getCommunityId())) {
			community=communityJPARepository.save(community);
			log.info("Service layer-update method-exit");
			communityDto=convertEntityToDto(community);
			return communityDto;
		}
		log.error("Servive layer-update method-exception");
		throw new CommunityIdNotFoundException("Community with " + community.getCommunityId() + " does not for updation!");
	}

	@Override
	public CommunityDto findCommunityById(int id) throws CommunityIdNotFoundException {
		log.info("Service layer-find_community_by_ID method-entry");
		Optional<Community> communities = null;
		if (communityJPARepository.existsById(id))
		{
			communities = communityJPARepository.findById(id);
			CommunityDto communityDto=convertEntityToDto(communities.get());
			log.info("Service layer-find_community_by_ID method-exit");
			return communityDto;
		}
		throw new CommunityIdNotFoundException("community with " + id + " not found in the table!");
	}

	@Override
	public List<CommunityDto> getAllCommunities() {log.info("Service layer-Get_all_communities-entry");
	List<CommunityDto> communityDto = new ArrayList<CommunityDto>();
	List <Community> community = communityJPARepository.findAll();
	for(Community com:community)
	{
		communityDto.add(convertEntityToDto(com));
	}
	log.info("Service layer-Get_All_Communities-exit");
	return communityDto;

}
}

	
