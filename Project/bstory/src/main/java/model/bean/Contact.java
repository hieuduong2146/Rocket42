package model.bean;

public class Contact {
	private int id ;
	private String name ;
	private String emial;
	private String website;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmial() {
		return emial;
	}
	public void setEmial(String emial) {
		this.emial = emial;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Contact(int id, String name, String emial, String website, String message) {
		super();
		this.id = id;
		this.name = name;
		this.emial = emial;
		this.website = website;
		this.message = message;
	}
	
	
}
