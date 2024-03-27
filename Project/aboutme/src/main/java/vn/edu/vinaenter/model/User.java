package vn.edu.vinaenter.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	
	private int id;
	@Size(min = 3, max = 12)
	@NotBlank
	private String username;
	
	@NotBlank
	private String fullname;	
	
	
	private String password;
	
	private int enable;
	private Role role;
}
