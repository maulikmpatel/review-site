package org.wecancodeit.reviewsite;

public class Review {

	private Long id;
	private String title;
	private String imgUrl;
	private String catagory;
	private String content;

	public Review(Long id, String title, String imgUrl, String catagory, String content) {
		this.id = id;
		this.title = title;
		this.imgUrl = imgUrl;
		this.catagory = catagory;
		this.content = content;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getCatagory() {
		return catagory;
	}

	public String getContent() {
		return content;
	}

}
