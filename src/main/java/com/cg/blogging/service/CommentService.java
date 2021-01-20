package com.cg.blogging.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.blogging.dto.CommentDto;
import com.cg.blogging.entities.Comment;
import com.cg.blogging.exception.IdNotFoundException;


@Service
public interface CommentService {
	
	public CommentDto addComment(CommentDto commentDto);
	public List<CommentDto> deleteCommentById(int id) throws IdNotFoundException;
	public List<CommentDto> viewAllComments();
	public CommentDto findCommentsById(int id) throws IdNotFoundException;
	public CommentDto updatecomment(CommentDto commentDto) throws IdNotFoundException;
	public List<CommentDto> findCommentsByPostId(int id);
}