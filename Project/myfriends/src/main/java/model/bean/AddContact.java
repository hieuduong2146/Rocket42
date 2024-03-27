package model.bean;

public class AddContact {
	private int id ;
	private String name;
	private String email;
	private int phone;
	private String content;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public AddContact() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddContact(int id, String name, String email, int phone, String content) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.content = content;
	}
	public AddContact(String name, String email, int phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	
}
