/**
 * 
 */
package com.sk.blog.springbootblogrestapi.service.impl;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sk.blog.springbootblogrestapi.entity.Post;
import com.sk.blog.springbootblogrestapi.exception.ResourceNotFoundException;
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
		Post savedPost = postRepository.save(post);
		BeanUtils.copyProperties(savedPost,postDto);
		return postDto;
	}


	@Override
	public List<PostDto> getAllPosts(int pageNo,int pageSize) {
		Pageable pageable = PageRequest.of(pageNo,pageSize);
		Page<Post> posts = postRepository.findAll(pageable);
		List<Post> allPosts = posts.getContent();
		return allPosts.stream().map((post)->{ 
			PostDto postDto = new PostDto();
			BeanUtils.copyProperties(post,postDto);
			return postDto;
		}).collect(Collectors.toList());
	}


	@Override
	public PostDto getPostById(Long id) {
		Optional<Post> opPost = Optional.of(postRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Post","id",id.toString())));
		PostDto postDto = new PostDto();
		if(opPost.isPresent()) {
			Post post = opPost.get();
			BeanUtils.copyProperties(post, postDto);
		}
		return postDto;
	}


	@Override
	public PostDto updatePostById(PostDto postDto, Long id) {
		Post post  = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id.toString()));
		//BeanUtils.copyProperties(postDto,post);
		mapToPost(postDto,post);
		Post updatedPost = postRepository.save(post);
		BeanUtils.copyProperties(updatedPost,postDto);
		return postDto;
	}
	
	public void mapToPost(PostDto postDto,Post post) {
		post.setTitle(postDto.getTitle());
		post.setDescription(postDto.getDescription());
		post.setContent(postDto.getContent());
	}
	public void mapToPostDto(Post post,PostDto postDto) {
		postDto.setTitle(post.getTitle());
		postDto.setDescription(post.getDescription());
		postDto.setContent(post.getContent());
	}


	@Override
	public void deletePostById(Long id) {
		Post post = postRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Post","id",id.toString()));
		postRepository.delete(post);
	}

}
