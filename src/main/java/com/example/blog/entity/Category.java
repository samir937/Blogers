package com.example.blog.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="Categories")
public class Category {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int categoryId;
	@Column(name="Title",nullable = false)
	private String categoryTitle;
	@Column(name="Description",nullable = false)
	private String categoryDescription;
//	@OneToMany
//	private List<Post> post;
	
}
