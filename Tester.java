import java.util.ArrayList;
import java.util.Scanner;

public class Tester {
	
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Book>b =new ArrayList<Book>();
		bookstoreService Service = new bookstoreService(b);
		ArrayList<NewBook>newb = new ArrayList<NewBook>();
		ArrayList<SecondhandBook>secb = new ArrayList<SecondhandBook>();
		
		
		
		 
		
			
		
		System.out.println("-------------�F�j�ѫ�------------");
		
		
		Book b1 = new NewBook("java���", "�{���]�p", 1200,10);
		Book b2 = new SecondhandBook("java","oop",1200,"�i�T","123");
		Service.add(b1);
		Service.add(b2);
		
		while(true) {
		System.out.println("�п�J�Q�n�i�檺�A��:");
		System.out.println("1.�W�K���y\n2.�R�����y\n3.�����y��T\n4.�d�߮��y\n5.�ʶR���y\n6.�d���ʪ���\n��J-1�h�X");
		int choice;
		choice = sc.nextInt();
		if(choice == 1) {
			int title=0;
			String name;
			String lesson;
			int price;
			System.out.println("�аݭn�[�J���Ѻ�:1.�s�� 2.�G���:");
			title = sc.nextInt();
			
			if(title==1) {
				
				int booknum;
				System.out.println("�ѦW: \n �ҵ{: \n ����: \n  �ƶq:");
				name=sc.next();
				lesson = sc.next();
				price = sc.nextInt();
				booknum = sc.nextInt();
				Service.add(new NewBook(name, lesson, price, booknum));
       
				}else if(title == 2) {
					String offer;
					String condi;
					System.out.println("�ѦW: \n �ҵ{: \n ����: \n ���ѤH:\n  �Ѫp:");
					name=sc.next();
					lesson = sc.next();
					price = sc.nextInt();
					offer =sc.next();
					condi = sc.next();
					Service.add(new SecondhandBook(name, lesson,price,offer,condi));
				}
			
		
			
			
		}else if(choice ==2) {
			int title;
			System.out.println("�аݭn�R�����Ѻ�:1.�s�� 2.�G���:");
			title = sc.nextInt();
			if(title==1) {
				Service.getnewinfo();
				System.out.println("�п�J�n�R�����Ѫ��W�r:");
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
				System.out.println("�п�J�n�R�����Ѫ��W�r:");
				String name;
				name = sc.next();
				for(Book o:b) {
					if(o.getName().equals(name)) {
						Service.getSecb().remove(o);
					}
				
				}
			
			
			}
			
		
		}else if(choice == 3) {
			
			
			System.out.println("�аݭn����T���Ѻ�:1.�s�� 2.�G���:");
			int title;
			title = sc.nextInt();
			if(title == 1) {
				Service.getnewinfo();
				System.out.println("�п�J�n����T���Ѫ��s��:");
				int num;
				num = sc.nextInt();
//				for(NewBook o:newb) {
//					System.out.println(newb.get(num).getBooknum());
////						String s = "";
////						int i;
////						System.out.println("�ѦW("+o.getName()+"):");
////						s = sc.next();
////						if(sc.hasNext()) {
////							o.setName(s);
//						}
				for(Book o:Service.getNewb()) {		
					if(num == Service.getNewb().indexOf(o)) {
						String s = "";
					int i;
					System.out.println("�ѦW("+o.getName()+"):");
					s = sc.next();
					o.setName(s);
					}else {
						
					}
				}
						
						
			
						
//					}else {
//						System.out.println("�d�L����");
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
//				System.out.println("<�s��>");
//				for(NewBook n:newb) {
//					System.out.println("�s��"+newb.indexOf(n)+"   �ѦW: "+n.getName()+"   �ҵ{: "+n.getLesson()+"  ����: "+n.getPrice()+"�ƶq:"+n.getBooknum());
//				}
//				System.out.println("------------------------------------------------------------");
//				System.out.println("<�G���>");
//				if(secb.isEmpty()) {
//					System.out.println("�d�L����");
//				}else {
//				for(SecondhandBook s:secb) {
//					
//					System.out.println("�s��"+secb.indexOf(s)+"   �ѦW: "+s.getName()+"   �ҵ{: "+s.getLesson()+"  ����: "+s.getPrice()+"���ѤH: "+s.getOffer()+"�Ѫp:"+s.getCondition());
//				
//					}
//				}
			Service.getinfo();
		
			
			
		}else if (choice == -1) {
			System.out.println("Thanks!");
			break;
		
		}else if (choice == 5) {
		
			int title=0;
			
			System.out.println("�аݭn�ʶR���Ѻ�:1.�s�� 2.�G���:");
			title = sc.nextInt();
			
			if(title==1) {
				Service.getnewinfo();
				
				System.out.println("�п�J�n�ʶR���Ѫ��W�r:");
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
					System.out.println("�п�J�n�ʶR���Ѫ��W�r:");
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


