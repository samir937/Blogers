package com.example.blog.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="Posts")
public class Post {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int postId;
	@Column(name="post_Title", nullable = false)
	private String postTitle;
	private String content;
	private String postImage;
	private Date addedDate;
	@ManyToOne
	private User user;
	@ManyToOne
	@JoinColumn(name="category_id")
	private Category category;

}
