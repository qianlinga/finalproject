import java.util.ArrayList;

public class bookstoreService {
	
	private ArrayList<Book>b = new ArrayList<Book>();
	private ArrayList<NewBook>newb = new ArrayList<NewBook>();
	private ArrayList<SecondhandBook>secb = new ArrayList<SecondhandBook>();
	private Shoppingcar car = new Shoppingcar(); 
	public Shoppingcar getCar() {
		return car;
	}

	public void setCar(Shoppingcar car) {
		this.car = car;
	}

	private int newid=1;
	private int secid=1;
	
	
	
	public bookstoreService() {
		super();
	}

	public bookstoreService(ArrayList<Book> b) {
		super();
		this.b = b;
	}

	public void add(Book book) {
		b.add(book);
		if(book instanceof NewBook) {
			NewBook n = (NewBook)book;
			newb.add(n);
			
		}else if(book instanceof SecondhandBook) {
			SecondhandBook s =(SecondhandBook)book;
			secb.add(s);
		}
		
	}
	
	public void purchase(Book book) {
		car.getB().add(book);
		
		
	}
	
	
	public void del(Book book) {
		b.remove(book);
		if(book instanceof NewBook) {
			NewBook n = (NewBook)book;
			newb.remove(n);
			
		}else if(book instanceof SecondhandBook) {
			SecondhandBook s =(SecondhandBook)book;
			secb.remove(s);
		}
	}
	
	
	
	
	public ArrayList<NewBook> getNewb() {
		return newb;
	}

	public void setNewb(ArrayList<NewBook> newb) {
		this.newb = newb;
	}

	public ArrayList<SecondhandBook> getSecb() {
		return secb;
	}

	public void setSecb(ArrayList<SecondhandBook> secb) {
		this.secb = secb;
	}
	
	
	public void getinfo() {
		
			System.out.println("<新書>");
			for(NewBook n:newb) {
				System.out.println("編號"+newb.indexOf(n)+"   書名: "+n.getName()+"   課程: "+n.getLesson()+"  價錢: "+n.getPrice()+"數量:"+n.getBooknum());
			}
			System.out.println("------------------------------------------------------------");
			System.out.println("<二手書>");
			if(secb.isEmpty()) {
				System.out.println("查無此類");
			}else {
			for(SecondhandBook s:secb) {
				
				System.out.println("編號"+secb.indexOf(s)+"   書名: "+s.getName()+"   課程: "+s.getLesson()+"  價錢: "+s.getPrice()+"提供人: "+s.getOffer()+"書況:"+s.getCondition());
			
				}
			}
	}
	
	public void getnewinfo() {
		
		System.out.println("<新書>");
		for(NewBook n:newb) {
			System.out.println("編號"+newb.indexOf(n)+"   書名: "+n.getName()+"   課程: "+n.getLesson()+"  價錢: "+n.getPrice()+"數量:"+n.getBooknum());
		}

	}
	
	public void getsecinfo() {
		
			
			if(secb.isEmpty()) {
				System.out.println("查無此類");
			}else {
			for(SecondhandBook s:secb) {
				
				System.out.println("編號"+secb.indexOf(s)+"   書名: "+s.getName()+"   課程: "+s.getLesson()+"  價錢: "+s.getPrice()+"提供人: "+s.getOffer()+"書況:"+s.getCondition());
			
				}
			}
		}
    
	

	
	

}
