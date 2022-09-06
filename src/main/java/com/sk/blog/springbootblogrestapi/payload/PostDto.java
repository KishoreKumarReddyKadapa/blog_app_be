/**
 * 
 */
package com.sk.blog.springbootblogrestapi.payload;

import lombok.Data;

/**
 * @author kishore.kumarreddy
 *
 */
@Data
public class PostDto {
	private Long id;
	private String title;
	private String description;
	private String content;
	
}
