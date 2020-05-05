package kim.dongyoung.bookstore.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import kim.dongyoung.bookstore.domain.Book;
import kim.dongyoung.bookstore.domain.Cart;
import kim.dongyoung.bookstore.domain.Order;
import kim.dongyoung.bookstore.domain.Refund;
import kim.dongyoung.bookstore.domain.Sales;
import kim.dongyoung.bookstore.domain.Shelf;
import kim.dongyoung.bookstore.presentation.Console;
import kim.dongyoung.bookstore.presentation.MenuImpl;

final public class HostImpl extends MenuImpl implements Host {
	
	//싱글톤 이용법==> HostImpl.getInstance().bookList();
	static HostImpl h = new HostImpl();
	public static HostImpl getInstance() {
		return h;
		
}
	
	@Override
	public void HostLogin() { //관리자 로그인
		// TODO Auto-generated method stub
	try {
		Map<String,String> a = new HashMap<String,String>();
		a.put("host1","1");
		
		while(true){
			
		System.out.println("관리자 ID:");
		String id =Console.stringInput(); //아이디 입력받는다.
		
		System.out.print("관리자 PW:");
		String pw =Console.stringInput(); //비번 입력받는다.
		
		if(a.containsKey(id)) { //해시맵 a 에 입력받은 아이디 값과 일치하는 값이 있는가?
			//a.get(id): 압력받은 id(key)가 되어 값(패스워드)
			 if(a.get(id).equals(pw)) {//비밀번호 일치
				 System.out.println("==============================");
				 System.out.println("\t로그인 되었습니다^^*.");
				 System.out.println("===============================");
				 commonMenu(HOST_MENU);
				 break;//반복문을 빠져나간다.	
			 } else{
				 System.out.println("비밀번호가 일치하지 않습니다.");
			 } 
		 }else {//아이디가 없으면
			 System.out.println("입력하신 아니디가 존재하지 않습니다.");
		 }	
		}
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	
	@Override
	public void bookList() { //책목록
		
		try {
			System.out.println("===============도서목록===============");
			System.out.println("번호\t 도서명\t 저자\t 가격\t 수량\t ");
			System.out.println("=====================================");
			//Shelf클래스book맵의 키와 값을 처음부터 끝까지 s맵에 담는다
			for(Map.Entry<Integer, Book> s : Shelf.book.entrySet() ){
					System.out.print(s.getKey());
					System.out.println(s.getValue());
			}commonMenu(HOST_STOCK_MENU);//관리자 재고관리로 돌아가기.
			 

		}catch(Exception e){
			e.printStackTrace();
		}

	}

	@Override
	public void bookAdd() { //책추가
		
		try {
			Random rr= new Random();
			int random = rr.nextInt(100)+1; 
			//랜덤함수: 여기서 100은 최대 숫자를 나타내며,  +1은 시작숫자를 나타낸다.
			
			String bookName;
			String auther;
			int bookPrice;
			int bookCount;
		
			System.out.println("===============도서등록===============");
			System.out.println("도서명 : ");
			bookName=Console.stringInput();
			System.out.println("저자 : ");
			auther=Console.stringInput();
			System.out.println("가격 : ");
			bookPrice=Console.intInput();
			System.out.println("수량 : ");
			bookCount=Console.intInput();
			
			Book book =new Book(random, bookName, auther, bookPrice, bookCount);
			Shelf.book.put(random, book);
			
			
			System.out.println("====================================");
			System.out.println("\t도서가 등록되었습니다.");
			System.out.println("====================================");
			commonMenu(HOST_STOCK_MENU); //다시 재고메뉴를 불러들인다.
		}catch(Exception e){
			e.printStackTrace();
		}
		}

	@Override
	public void bookUpdate() { //책수정
		// TODO Auto-generated method stub
		try {
			while(true) {
			System.out.print("수정하려는 책의 코드를 입력하세요. 이전[:0] : ");
			int guestBookCode =Console.intInput(); 
			
			if (guestBookCode==0) {
				commonMenu(HOST_STOCK_MENU);
				
			}else if(Shelf.book.containsKey(guestBookCode)) { //입력받은 a코드를 포함하고 있니?		
				
				System.out.println("도서명 : ");
				String bookName=Console.stringInput();
				System.out.println("저자 : ");
				String auther= Console.stringInput();//input.next();
				System.out.println("가격 : ");
				int bookPrice=Console.intInput();
				System.out.println("수량 : ");
				int bookCount=Console.intInput();
				
				Book book =new Book(guestBookCode, bookName, auther, bookPrice, bookCount);
				//Book클래스로 입력값을 넘겨준다.
				Shelf.book.put(guestBookCode, book);
				//Shelf 클래스의 book 맵에 입력받은 키와, Book클래스의 데이터를 참조변수로 읽어들인후 대입
				
				System.out.println("====================================");
				System.out.println("\t도서가 수정되었습니다.");
				System.out.println("====================================");
			
				commonMenu(HOST_STOCK_MENU);//관리자 재고관리로 돌아가기.
			}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	@Override
	public void bookDel() { //책삭제
		// TODO Auto-generated method stub
		try {
			while(true) {
				System.out.print("삭제하려는 책의 코드를 입력하세요. 이전[:0] : ");
				int guestBookCode = Console.intInput();
				
				if(guestBookCode==0) {
					commonMenu(HOST_STOCK_MENU);//관리자 재고관리로 돌아가기.
					//HostImpl.getInstance().hostStockMenu(); 같은 의미.
				
				}else if(Shelf.book.containsKey(guestBookCode)){//일치하는 키값이 있는가?
					
					Shelf.book.remove(guestBookCode);//입력받은 키값의 키와 데이터를 book에서 삭제한다.
					System.out.println("===============도서삭제===============");
					System.out.println("\t"+guestBookCode+"번 도서가 삭제 되었습니다.");
					System.out.println("=====================================");
							}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	@Override
	public void orderList() { //관리자 주문목록
		// TODO Auto-generated method stub
		try {
			System.out.println("===============구매 요청 목록===============");
			System.out.println("번호\t 도서명\t 저자\t 가격\t 수량\t ");
			System.out.println("=====================================");
			
			for(Map.Entry<Integer, Book> s : Order.order.entrySet() ){
				System.out.print(s.getKey());
				System.out.println(s.getValue());
			}
			commonMenu(HOST_ORDER_MENU );//관리자 주문관리.
		}catch(Exception e){
			e.printStackTrace();
		}
	}		
	
	@Override
	public void orderConfirm() { //관리자 결제승인
		// TODO Auto-generated method stub
		while(true) {
			System.out.print("구매 승인할 코드를 입력하세요. 이전[:0] : ");
			int guestBookCode = Console.intInput();
				if(guestBookCode==0) {
					commonMenu(HOST_ORDER_MENU);//관리자 주문관리	
				}else if(Shelf.book.containsKey(guestBookCode)){
					// 구매할 키를 Sales 클래스의 맵에넣음.
					Sales.sales.put(guestBookCode,Order.order.get(guestBookCode));
					
					//관리자가 결재승인을 하였으니. (전체 재고 - 구매한것의 수량)을 시행한다.
					String bookName= Sales.sales.get(guestBookCode).getBookName();
					String auther= Sales.sales.get(guestBookCode).getAuther();
					int bookPrice= Sales.sales.get(guestBookCode).getBookPrice();
					int bookCount= (Shelf.book.get(guestBookCode).getBookCount())-(Sales.sales.get(guestBookCode).getBookCount());
					
					//원래 도서목록에 수정된 수량을 넣어준다.
					Shelf.book.put(guestBookCode,new Book(guestBookCode,bookName,auther,bookPrice,bookCount));
			
					System.out.println("=====================================");
					System.out.println("\t결제승인 되었습니다.!!");
					System.out.println("=====================================");
					
					// 결제승인 되었으니. 카트에 들어있는 목록을 뺀다.
					Cart.cart.remove(guestBookCode); 
					commonMenu(HOST_ORDER_MENU);
					
				}
		}
	}

	@Override
	public void saleTotal() { //관리자 결산 (어려운 구간)
		// TODO Auto-generated method stub
		int a,b,total = 0;
		//sales의 책가격 값과 책수량값을 곱한후 total에 담는다.
		for(Map.Entry<Integer,Book> s : Sales.sales.entrySet()){
			a= Sales.sales.get(s.getKey()).getBookPrice();
			b= Sales.sales.get(s.getKey()).getBookCount();
			total+=a*b;
		}//
			System.out.println("결산 : "+total);
		
	}
	
	@Override
	public void orderCancel() throws NullPointerException { //관리자 환불승인
		System.out.println("===============환불 요청 목록===============");
		System.out.println("번호\t 도서명\t 저자\t 가격\t 수량\t ");
		System.out.println("=====================================");
		for(Map.Entry<Integer, Book> s : Refund.refund.entrySet() ){
			System.out.print(s.getKey());
			System.out.println(s.getValue());
		}
		try {
		while(true) {
			System.out.print("환불처리할 코드를 입력하세요. 이전[:0] : ");
			int guestBookCode = Console.intInput();
					if(guestBookCode==0) {
						commonMenu(HOST_ORDER_MENU);//관리자 주문관리	
					}else if(Shelf.book.containsKey(guestBookCode)){//일치하는 키값이 있는가?
						//구매완료 목록에서 환불한 키와 데이터를 삭제한다.
						Sales.sales.remove((Object)guestBookCode);
						// 책목록의 수량을 환불한만큼 늘려주기.
						String bookName= Sales.sales.get(guestBookCode).getBookName();
						String auther= Sales.sales.get(guestBookCode).getAuther();
						int bookPrice= Sales.sales.get(guestBookCode).getBookPrice();
						int bookCount= (Shelf.book.get(guestBookCode).getBookCount())+(Refund.refund.get(guestBookCode).getBookCount());
						
						Shelf.book.put(guestBookCode,new Book(guestBookCode,bookName,auther,bookPrice,bookCount));

						System.out.println("=====================================");
						System.out.println("\t환불처리 되었습니다.ㅠㅠ");
						System.out.println("=====================================");
						commonMenu(HOST_ORDER_MENU);
					}
				
		}
		}catch(NumberFormatException e) {
			System.out.println("replace of korean at home");
		}catch(NullPointerException e) {
			System.out.println("anymore no list");
		} catch (Exception e) {
			// TODO Auto-generated catch block				
		}

		
	}
}