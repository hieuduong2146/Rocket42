package vn.edu.vinaenter.model;

import java.sql.Timestamp;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class News {
	private  int id;
	@NotBlank
	private String name;
	
	private String picture;
	@NotBlank
	private String detail;
	
	private int count_views;
	
	private Timestamp date_create;
	
	private int status;
	
	private Category category;
}
