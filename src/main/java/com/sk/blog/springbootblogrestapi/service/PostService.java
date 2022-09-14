/**
 * 
 */
package com.sk.blog.springbootblogrestapi.service;

import com.sk.blog.springbootblogrestapi.payload.PostDto;
import com.sk.blog.springbootblogrestapi.payload.PostResponse;

/**
 * @author kishore.kumarreddy
 *
 */
public interface PostService {
	
	PostDto createPost(PostDto postDto);
	PostResponse getAllPosts(int pageNo,int pageSize,String sortBy, String sortDir);
	PostDto getPostById(Long id);
	PostDto updatePostById(PostDto postDto, Long id);
	void deletePostById(Long id);

}
