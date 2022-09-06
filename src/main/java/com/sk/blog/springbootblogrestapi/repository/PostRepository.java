/**
 * 
 */
package com.sk.blog.springbootblogrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sk.blog.springbootblogrestapi.entity.Post;

/**
 * @author kishore.kumarreddy
 *
 */
public interface PostRepository extends JpaRepository<Post, Long> {

}
