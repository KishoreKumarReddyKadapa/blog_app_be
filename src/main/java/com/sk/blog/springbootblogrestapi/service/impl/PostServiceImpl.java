/**
 * 
 */
package com.sk.blog.springbootblogrestapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.sk.blog.springbootblogrestapi.entity.Post;
import com.sk.blog.springbootblogrestapi.payload.PostDto;
import com.sk.blog.springbootblogrestapi.repository.PostRepository;
import com.sk.blog.springbootblogrestapi.service.PostService;

/**
 * @author kishore.kumarreddy
 *
 */
@Service
public class PostServiceImpl implements PostService {
	
	private PostRepository postRepository;
	

	public PostServiceImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}


	@Override
	public PostDto createPost(PostDto postDto) {
		Post post = new Post();
			
		BeanUtils.copyProperties(postDto,post);
		System.out.println(post.toString());
		Post savedPost = postRepository.save(post);
		BeanUtils.copyProperties(savedPost,postDto);
		return postDto;
	}


	@Override
	public List<PostDto> getAllPosts() {
		List<Post> allPosts = postRepository.findAll();
		return allPosts.stream().map((post)->{ 
			PostDto postDto = new PostDto();
			BeanUtils.copyProperties(post,postDto);
			return postDto;
		}).collect(Collectors.toList());
	}


	@Override
	public PostDto getPostById(Long id) {
		return null;
	}

}
