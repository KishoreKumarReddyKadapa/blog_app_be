/**
 * 
 */
package com.sk.blog.springbootblogrestapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sk.blog.springbootblogrestapi.payload.PostDto;
import com.sk.blog.springbootblogrestapi.service.PostService;

/**
 * @author kishore.kumarreddy
 *
 */
@RestController
@RequestMapping("/api/posts")
public class PostController {

	PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@PostMapping
	public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto){
		return new ResponseEntity<PostDto>(postService.createPost(postDto), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<PostDto>> getAllPosts(){
		return new ResponseEntity<>(postService.getAllPosts(), HttpStatus.OK);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable Long id){
		return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
	}
	
}
