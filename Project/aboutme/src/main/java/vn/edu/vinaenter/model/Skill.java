package vn.edu.vinaenter.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
	private int id;
	
	@NotBlank
	private String name;
	
	@NotNull
	private Integer value;
}
