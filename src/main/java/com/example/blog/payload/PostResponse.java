package com.example.blog.payload;

import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PostResponse {
	private List<PostDto> content;
	private int pageSize;
	private int pageNumber;
	private int totalPages;
	private long totalElements;
	private boolean lastPage;

}
