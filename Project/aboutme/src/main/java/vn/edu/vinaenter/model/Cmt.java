package vn.edu.vinaenter.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cmt {
	private int id;
	private String comment;
	private Timestamp time;
	private News news;
}
