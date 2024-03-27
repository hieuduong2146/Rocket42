package vn.edu.vinaenter.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Land {
	private int lid;	
	@NotBlank
	private String lname;	
	@NotBlank
	private String description;
	private Timestamp date_create;	
	private String picture;		
	private int area;
	@NotBlank
	private String address;
	private int count_views;
	@NotBlank
	private String detail;
	private Category category;
	
}
