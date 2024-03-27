package model.bean;

public class DanhMucTin {
	private int idDMT;
	private String tenDMT;
	
	public int getIdDMT() {
		return idDMT;
	}
	public void setIdDMT(int idDMT) {
		this.idDMT = idDMT;
	}
	public String getTenDMT() {
		return tenDMT;
	}
	public void setTenDMT(String tenDMT) {
		this.tenDMT = tenDMT;
	}
	public DanhMucTin() {
		super();
	}
	public DanhMucTin(int idDMT, String tenDMT) {
		super();
		this.idDMT = idDMT;
		this.tenDMT = tenDMT;
	}
	
	public String toString() {
		return "idDMT :" + idDMT + "tenDMT : " + tenDMT;	
	}
}
