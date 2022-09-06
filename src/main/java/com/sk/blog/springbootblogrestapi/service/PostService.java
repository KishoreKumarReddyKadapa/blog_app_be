/**
 * 
 */
package com.sk.blog.springbootblogrestapi.service;

import java.util.List;

import com.sk.blog.springbootblogrestapi.payload.PostDto;

/**
 * @author kishore.kumarreddy
 *
 */
public interface PostService {
	
	PostDto createPost(PostDto postDto);
	List<PostDto> getAllPosts();
	PostDto getPostById(Long id);

}
