/**
 * 
 */
package com.sk.blog.springbootblogrestapi.payload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * @author kishore.kumarreddy
 *
 */
@Data
public class PostDto {
	
	private Long id;
	
	@NotEmpty
	@Size(min=2,message="Post Title should have atlease 2 characters")
	private String title;
	
	@NotEmpty
	private String description;
	@NotEmpty
	private String content;
	
}
