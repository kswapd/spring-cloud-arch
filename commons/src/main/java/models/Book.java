package models;

/**
 * Created by kongxiangwen on 5/7/18 w:19.
 */
public class Book {
	private String title = "book1";
	private String author;
	private int price;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
