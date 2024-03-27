package model.bean;

import java.sql.Timestamp;

import model.bean.Category;

public class Stories {
	private int id;
	private String name;
	private	String preview_text;
	private String detail_text;
	private Timestamp date_create;
	private String picture;
	private int counter;
	private Category category;
	private int uid;
	
	public Stories(int id, String name, String preview_text, Timestamp date_create, String picture, int counter,
			Category category, int uid) {
		super();
		this.id = id;
		this.name = name;
		this.preview_text = preview_text;
		this.date_create = date_create;
		this.picture = picture;
		this.counter = counter;
		this.category = category;
		this.uid = uid;
	}
	public Stories(int id, String name, String preview_text, String detail_text, Timestamp date_create, String picture,
			int counter, Category category, int uid) {
		super();
		this.id = id;
		this.name = name;
		this.preview_text = preview_text;
		this.detail_text = detail_text;
		this.date_create = date_create;
		this.picture = picture;
		this.counter = counter;
		this.category = category;
		this.uid = uid;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
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
	public String getPreview_text() {
		return preview_text;
	}
	public void setPreview_text(String preview_text) {
		this.preview_text = preview_text;
	}
	public String getDetail_text() {
		return detail_text;
	}
	public void setDetail_text(String detail_text) {
		this.detail_text = detail_text;
	}
	public Timestamp getDate_create() {
		return date_create;
	}
	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public int getCounter() {
		return counter;
	}
	public void setCounter(int counter) {
		this.counter = counter;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public Stories() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stories(int id, String name, String preview_text, String detail_text, Timestamp date_create, String picture,
			int counter, Category category) {
		super();
		this.id = id;
		this.name = name;
		this.preview_text = preview_text;
		this.detail_text = detail_text;
		this.date_create = date_create;
		this.picture = picture;
		this.counter = counter;
		this.category = category;
	}
	public Stories(int id, String name, String preview_text, Timestamp date_create, String picture, int counter,
			Category category) {
		super();
		this.id = id;
		this.name = name;
		this.preview_text = preview_text;
		this.date_create = date_create;
		this.picture = picture;
		this.counter = counter;
		this.category = category;
	}
	
	
}
