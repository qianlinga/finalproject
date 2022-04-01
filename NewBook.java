
public class NewBook extends Book {

	int booknum;
	
	public NewBook(String name, String lesson, int price, int booknum) {
		super(name, lesson, price);
		this.booknum = booknum;
		// TODO Auto-generated constructor stub
	}

	public int getBooknum() {
		return booknum;
	}

	public void setBooknum(int booknum) {
		this.booknum = booknum;
	}
	
	

	
}
