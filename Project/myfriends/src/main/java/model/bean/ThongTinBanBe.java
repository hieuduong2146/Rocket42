package model.bean;

import java.sql.Timestamp;

public class ThongTinBanBe {
	private int fid;
	private String fname;
	private String preview;
	private Timestamp date_create;
	private String images;
	private String detail;
	private int fl_id;
	private int count_number;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getPreview() {
		return preview;
	}
	public void setPreview(String preview) {
		this.preview = preview;
	}
	public Timestamp getDate_create() {
		return date_create;
	}
	public void setDate_create(Timestamp date_create) {
		this.date_create = date_create;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getFl_id() {
		return fl_id;
	}
	public void setFl_id(int fl_id) {
		this.fl_id = fl_id;
	}
	public int getCount_number() {
		return count_number;
	}
	public void setCount_number(int count_number) {
		this.count_number = count_number;
	}
	public ThongTinBanBe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ThongTinBanBe(int fid, String fname, String preview, Timestamp date_create, String images, String detail,
			int fl_id, int count_number) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.preview = preview;
		this.date_create = date_create;
		this.images = images;
		this.detail = detail;
		this.fl_id = fl_id;
		this.count_number = count_number;
	}
	public ThongTinBanBe(int fid, String fname, String preview, Timestamp date_create) {
		super();
		this.fid = fid;
		this.fname = fname;
		this.preview = preview;
		this.date_create = date_create;
	}
	
	
	 
	
}
