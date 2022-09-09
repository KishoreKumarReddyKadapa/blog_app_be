/**
 * 
 */
package com.sk.blog.springbootblogrestapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sk.blog.springbootblogrestapi.payload.PostDto;
import com.sk.blog.springbootblogrestapi.payload.PostResponse;
import com.sk.blog.springbootblogrestapi.service.PostService;
import com.sk.blog.springbootblogrestapi.utils.AppConstants;

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
	public ResponseEntity<PostResponse> getAllPosts(
			@RequestParam(value="pageNo", defaultValue=AppConstants.DEFAULT_PAGE_NUMBER, required=false) int pageNo,
			@RequestParam(value="pageSize", defaultValue=AppConstants.DEFAULT_PAGE_SIZE, required=false) int pageSize,
			@RequestParam(value="sortBy", defaultValue=AppConstants.DEFAULT_SORT_BY, required=false) String sortBy,
			@RequestParam(value="sortDir", defaultValue=AppConstants.DEFAULT_SORT_DIRECTION, required=false) String sortDir){
		return new ResponseEntity<>(postService.getAllPosts(pageNo,pageSize,sortBy,sortDir), HttpStatus.OK);
	}
	@GetMapping(value="/{id}")
	public ResponseEntity<PostDto> getPostById(@PathVariable(name="id") Long id){
		return new ResponseEntity<>(postService.getPostById(id), HttpStatus.OK);
	}
	
	@PutMapping(value="/{id}")
	public ResponseEntity<PostDto> updatePostById(@RequestBody  PostDto postDto,@PathVariable(name="id") Long id){
		return new ResponseEntity<>(postService.updatePostById(postDto, id), HttpStatus.OK);
	}
	@DeleteMapping(value="/{id}")
	public ResponseEntity<String> deletePostById(@PathVariable(name="id") Long id){
		postService.deletePostById(id);
		return new ResponseEntity<>(String.format("Post Deleted Successfully...with post id: %s",id), HttpStatus.OK);
	}
	
}
