package model.bean;

public class DanhMucBanBe {
	private int idFR;
	private String danhmucFR;
	
	public int getIdFR() {
		return idFR;
	}
	public void setIdFR(int idFR) {
		this.idFR = idFR;
	}
	public String getDanhmucFR() {
		return danhmucFR;
	}
	public void setDanhmucFR(String danhmucFR) {
		this.danhmucFR = danhmucFR;
	}
	public DanhMucBanBe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public DanhMucBanBe(int idFR, String danhmucFR) {
		super();
		this.idFR = idFR;
		this.danhmucFR = danhmucFR;
	}
	
	
}
