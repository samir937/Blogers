package com.example.blog.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="Post")
@Getter
@Setter
@NoArgsConstructor
public class PostEntity {

	@Id
	private int id;
	private String post_content;
}
