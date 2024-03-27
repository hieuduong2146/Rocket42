package model.bean;

public class TinTuc {
	private int idNews;
	private String name;
	private String preview_text;
	private String detail_text;
	public int getIdNews() {
		return idNews;
	}
	
	
	public TinTuc(int idNews, String name, String preview_text, String detail_text) {
		super();
		this.idNews = idNews;
		this.name = name;
		this.preview_text = preview_text;
		this.detail_text = detail_text;
	}


	public String getDetail_text() {
		return detail_text;
	}

	public void setDetail_text(String detail_text) {
		this.detail_text = detail_text;
	}

	public void setIdNews(int idNews) {
		this.idNews = idNews;
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
	public TinTuc() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TinTuc(int idNews, String name, String preview_text) {
		super();
		this.idNews = idNews;
		this.name = name;
		this.preview_text = preview_text;
	}
	
	
}
