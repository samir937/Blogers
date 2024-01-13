package com.example.blog.payload;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
	
	private int id;
	@NotEmpty(message = "Name should not be empty")
	private String name;
	@Email(message = "Email id is not valid !!")
	private String email;
	@NotEmpty
	@Size(min = 3, max=10 ,message = "Password must be of min 3 chars and max=10 chars")
	private String password;
	@NotEmpty
	private String about;

}
