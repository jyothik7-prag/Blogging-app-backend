package com.cg.blogging.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.blogging.BloggingAppApplication;
import com.cg.blogging.dto.CommunityDto;
import com.cg.blogging.entities.Community;
import com.cg.blogging.exception.CommunityIdNotFoundException;
import com.cg.blogging.exception.IdNotFoundException;
import com.cg.blogging.exception.NullCommunityException;
import com.cg.blogging.service.CommunityService;
import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
@Validated
public class CommunityController {
	@Autowired
	private CommunityService communityService;
	private static final Logger log = LogManager.getLogger(BloggingAppApplication.class);
	
	
//	End point for update method
	@PutMapping("/community")
	public ResponseEntity<CommunityDto> updateCommunity(@Valid @RequestBody CommunityDto communitydto)
			throws CommunityIdNotFoundException {
		log.info("Controller layer- update method-entry");
		CommunityDto communityUpdate = null;
		communityUpdate = communityService.updateCommunity(communitydto);
		if (communityUpdate==null) {
			log.warn("No communities found");
			return new ResponseEntity("Sorry! Community not available!", HttpStatus.NOT_FOUND);
		}
		log.info("Controller layer- update method-exit");
		return new ResponseEntity<CommunityDto>(communityUpdate, HttpStatus.OK);
	}

	
//	End point for add community
	@PostMapping("/community")
	public ResponseEntity<CommunityDto> insertCommunity(@Valid @RequestBody CommunityDto communityDto)
			throws NullCommunityException {
		log.info("Controller layer- insert method-entry");
		CommunityDto addedCommunity = null;
		addedCommunity = communityService.addCommunity(communityDto);
		log.info("Controller layer- update method-exit");
		return new ResponseEntity<CommunityDto>(addedCommunity, HttpStatus.OK);
	}

	
//	End point for delete method
	@DeleteMapping("/community/{communityId}")
	public ResponseEntity<List<CommunityDto>> deleteCommunity(@PathVariable("communityId") Integer communityId)
			throws CommunityIdNotFoundException {
		log.info("Controller layer- delete method-entry");
		List<CommunityDto> communities = null;
		communities = communityService.deleteCommunityById(communityId);
		if (communities.isEmpty()) {
			log.warn("Community list is empty");
			return new ResponseEntity("Sorry! Community is not available!", HttpStatus.NOT_FOUND);
		}
		log.info("Controller layer- update method-exit");
		return new ResponseEntity<List<CommunityDto>>(communities, HttpStatus.OK);
	}

//	End point for getting community through Id
	@GetMapping("/community/{communityId}")
	public ResponseEntity<CommunityDto> findCommunity(@PathVariable("communityId") Integer communityId)
			throws CommunityIdNotFoundException {
		log.info("Controller layer- find community method-entry");
		CommunityDto communityDto = null;
		communityDto = communityService.findCommunityById(communityId);
		if (communityDto == null) {
			return new ResponseEntity("Sorry! Community not found!", HttpStatus.NOT_FOUND);

		}
		log.info("Controller layer- find community method-exit");
		return new ResponseEntity<CommunityDto>(communityDto, HttpStatus.OK);
	}

	
//	End point to get get all communities
	@GetMapping("/community")
	public ResponseEntity<List<CommunityDto>> getAllCommunities() {
		log.info("Controller layer- get all communities method-entry");
		List<CommunityDto> communities = new ArrayList<CommunityDto>();
		communities = communityService.getAllCommunities();
		if (communities.isEmpty()) {
			return new ResponseEntity("Sorry! Community not found!", HttpStatus.NOT_FOUND);
		}
		log.info("Controller layer-get all communities method-exit");
		return new ResponseEntity<List<CommunityDto>>(communities, HttpStatus.OK);
	}

}
