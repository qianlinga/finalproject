
public class Book {

	private String name;
	private String lesson;
	private int price;
	private boolean issold;
	
	public Book(String name, String lesson, int price) {
		super();
		this.name = name;
		this.lesson = lesson;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLesson() {
		return lesson;
	}

	public void setLesson(String lesson) {
		this.lesson = lesson;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isIssold() {
		return issold;
	}

	public void setIssold(boolean issold) {
		this.issold = issold;
	}
	
	
	
	
	
	
}
