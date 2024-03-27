package vn.edu.vinaenter.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Way {
	private int id;
	@NotBlank
	private String name;
	
	@NotBlank
	private String time;
	
	@NotBlank
	private String classify;
	
}
