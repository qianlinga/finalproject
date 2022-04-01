import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
	
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Book>b =new ArrayList<Book>();
		bookstoreService Service = new bookstoreService(b);
		ArrayList<NewBook>newb = new ArrayList<NewBook>();
		ArrayList<SecondhandBook>secb = new ArrayList<SecondhandBook>();
		
		
		
		 
		
			
		
		System.out.println("-------------政大書城------------");
		
		
		Book b1 = new NewBook("java初級", "程式設計", 1200,10);
		Book b2 = new SecondhandBook("java","oop",1200,"張三","123");
		Service.add(b1);
		Service.add(b2);
		
		while(true) {
		System.out.println("請輸入想要進行的服務:");
		System.out.println("1.增添書籍\n2.刪除書籍\n3.更改書籍資訊\n4.查詢書籍\n5.購買書籍\n6.查看購物車\n輸入-1退出");
		int choice;
		choice = sc.nextInt();
		if(choice == 1) {
			int title=0;
			String name;
			String lesson;
			int price;
			System.out.println("請問要加入的書種:1.新書 2.二手書:");
			title = sc.nextInt();
			
			if(title==1) {
				
				int booknum;
				System.out.println("書名: \n 課程: \n 價格: \n  數量:");
				name=sc.next();
				lesson = sc.next();
				price = sc.nextInt();
				booknum = sc.nextInt();
				Service.add(new NewBook(name, lesson, price, booknum));
       
				}else if(title == 2) {
					String offer;
					String condi;
					System.out.println("書名: \n 課程: \n 價格: \n 提供人:\n  書況:");
					name=sc.next();
					lesson = sc.next();
					price = sc.nextInt();
					offer =sc.next();
					condi = sc.next();
					Service.add(new SecondhandBook(name, lesson,price,offer,condi));
				}
			
		
			
			
		}else if(choice ==2) {
			int title;
			System.out.println("請問要刪除的書種:1.新書 2.二手書:");
			title = sc.nextInt();
			if(title==1) {
				Service.getnewinfo();
				System.out.println("請輸入要刪除的書的名字:");
				String name;
				name = sc.next();
				for(Book o:b) {
					if(o.getName().equals(name)) {
						b.remove(o);
						Service.getNewb().remove(o);
					}
				}
				
			}else if(title ==2) {
				Service.getsecinfo();
				System.out.println("請輸入要刪除的書的名字:");
				String name;
				name = sc.next();
				for(Book o:b) {
					if(o.getName().equals(name)) {
						Service.getSecb().remove(o);
					}
				
				}
			
			
			}
			
		
		}else if(choice == 3) {
			
			
			System.out.println("請問要更改資訊的書種:1.新書 2.二手書:");
			int title;
			title = sc.nextInt();
			if(title == 1) {
				Service.getnewinfo();
				System.out.println("請輸入要更改資訊的書的編號:");
				int num;
				num = sc.nextInt();
//				for(NewBook o:newb) {
//					System.out.println(newb.get(num).getBooknum());
////						String s = "";
////						int i;
////						System.out.println("書名("+o.getName()+"):");
////						s = sc.next();
////						if(sc.hasNext()) {
////							o.setName(s);
//						}
				for(Book o:Service.getNewb()) {		
					if(num == Service.getNewb().indexOf(o)) {
						String s = "";
					int i;
					System.out.println("書名("+o.getName()+"):");
					s = sc.next();
					o.setName(s);
					}else {
						
					}
				}
						
						
			
						
//					}else {
//						System.out.println("查無此書");
//					}
				}
			
			
		}else if(choice == 4) {
			
			
			 
//			for(Book o:b) {
//				if(o instanceof NewBook){
//					NewBook n = (NewBook)o;
//					newb.add(n);
//					
//					
//				}else if(o instanceof SecondhandBook) {
//					SecondhandBook s= (SecondhandBook)o;
//					secb.add(s);
//					
//					
//				}
//				
//			}
//				System.out.println("<新書>");
//				for(NewBook n:newb) {
//					System.out.println("編號"+newb.indexOf(n)+"   書名: "+n.getName()+"   課程: "+n.getLesson()+"  價錢: "+n.getPrice()+"數量:"+n.getBooknum());
//				}
//				System.out.println("------------------------------------------------------------");
//				System.out.println("<二手書>");
//				if(secb.isEmpty()) {
//					System.out.println("查無此類");
//				}else {
//				for(SecondhandBook s:secb) {
//					
//					System.out.println("編號"+secb.indexOf(s)+"   書名: "+s.getName()+"   課程: "+s.getLesson()+"  價錢: "+s.getPrice()+"提供人: "+s.getOffer()+"書況:"+s.getCondition());
//				
//					}
//				}
			Service.getinfo();
		
			
			
		}else if (choice == -1) {
			System.out.println("Thanks!");
			break;
		
		}else if (choice == 5) {
		
			int title=0;
			
			System.out.println("請問要購買的書種:1.新書 2.二手書:");
			title = sc.nextInt();
			
			if(title==1) {
				Service.getnewinfo();
				
				System.out.println("請輸入要購買的書的名字:");
				int num;
				num = sc.nextInt();
				
				
				for(Book n:b) {
					if(num == Service.getNewb().indexOf(n)) {
						Service.purchase(n);
						Service.getSecb().remove(n);
						
					}
				}
       
				}else if(title == 2) {
					Service.getsecinfo();
					System.out.println("請輸入要購買的書的名字:");
					int num;
					num = sc.nextInt();
					
					for(Book s:b) {
						if(num == Service.getSecb().indexOf(s)) {
							
							Service.purchase(s);
							Service.getSecb().remove(s);
						}
					}
					


					
				}
		}else if(choice == 6) {
			Service.getCar().getInfo();
		}
	}
	}
	
	
	
}


