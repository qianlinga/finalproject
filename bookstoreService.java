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
		
			System.out.println("<�s��>");
			for(NewBook n:newb) {
				System.out.println("�s��"+newb.indexOf(n)+"   �ѦW: "+n.getName()+"   �ҵ{: "+n.getLesson()+"  ����: "+n.getPrice()+"�ƶq:"+n.getBooknum());
			}
			System.out.println("------------------------------------------------------------");
			System.out.println("<�G���>");
			if(secb.isEmpty()) {
				System.out.println("�d�L����");
			}else {
			for(SecondhandBook s:secb) {
				
				System.out.println("�s��"+secb.indexOf(s)+"   �ѦW: "+s.getName()+"   �ҵ{: "+s.getLesson()+"  ����: "+s.getPrice()+"���ѤH: "+s.getOffer()+"�Ѫp:"+s.getCondition());
			
				}
			}
	}
	
	public void getnewinfo() {
		
		System.out.println("<�s��>");
		for(NewBook n:newb) {
			System.out.println("�s��"+newb.indexOf(n)+"   �ѦW: "+n.getName()+"   �ҵ{: "+n.getLesson()+"  ����: "+n.getPrice()+"�ƶq:"+n.getBooknum());
		}

	}
	
	public void getsecinfo() {
		
			
			if(secb.isEmpty()) {
				System.out.println("�d�L����");
			}else {
			for(SecondhandBook s:secb) {
				
				System.out.println("�s��"+secb.indexOf(s)+"   �ѦW: "+s.getName()+"   �ҵ{: "+s.getLesson()+"  ����: "+s.getPrice()+"���ѤH: "+s.getOffer()+"�Ѫp:"+s.getCondition());
			
				}
			}
		}
    
	

	
	

}
