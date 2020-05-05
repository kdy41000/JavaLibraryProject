
package kim.dongyoung.bookstore.domain;

import java.util.HashMap;
import java.util.Map;

public class Book {
	
	int random; // 랜덤함수.
	String bookName;
	String auther;
	int bookPrice;
	int bookCount;
	//변수명은 소문자
	
	//getter
	public String getBookName() {
		return bookName;
	}
	
	public Book() {
		
	}
	
	public Book(int random, String bookName, String auther, int bookPrice, int bookCount) {
		this.random=random;
		this.bookName = bookName;
		this.auther = auther;
		this.bookPrice = bookPrice;
		this.bookCount = bookCount;
	}

	
	public int getRandom() {
		return random;
	}

	public String getAuther() {
		return auther;
	}
	
	public int getBookPrice() {
		return bookPrice;
	}
	
	public int getBookCount() {
		return bookCount;
	}
	
	public String toString() {
		return 	"\t"+getBookName()
				+"\t"+getAuther()
				+"\t"+getBookPrice()
				+"\t"+getBookCount()+"\n";
		
	}
	
	
	

}
