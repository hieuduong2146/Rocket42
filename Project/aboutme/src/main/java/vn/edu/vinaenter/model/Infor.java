package vn.edu.vinaenter.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Infor {
	
	private int id;
	@NotBlank
	private String name;
	@NotBlank
	private String birthday;
	@Email
	private String email;
	@NotBlank
	private String address;
	@NotBlank
	private String phone;
	@NotBlank
	private String content;
	private int status;

}	
