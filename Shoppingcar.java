import java.util.ArrayList;

public class Shoppingcar {
	
	private ArrayList<Book>b = new ArrayList<Book>();
	private int amount=0;
	
	public Shoppingcar() {
		super();
		
	}

	public ArrayList<Book> getB() {
		return b;
	}

	public void setB(ArrayList<Book> b) {
		this.b = b;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public void getInfo() {
		System.out.println("hello");
		for(Book book:b) {
			System.out.println("®Ñ¦W:"+book.getName());
		}
		System.out.println("Á`ÃB:"+gettotal());
		
	
	
	}
	
	public int gettotal() {
		int total=0;
		for(Book book:b) {
			total = total + book.getPrice();
		}
		
		return total;
	}

}
