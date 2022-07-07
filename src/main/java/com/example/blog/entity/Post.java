package com.example.blog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int postId;
	
	
	private String postTitle;
	
	private String content;
	
	private String postImage;
	
	@ManyToOne
	private User user;
	
	@ManyToOne
	private Category category;
	

}
