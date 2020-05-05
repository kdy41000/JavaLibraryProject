package kim.dongyoung.bookstore.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import kim.dongyoung.bookstore.domain.Book;
import kim.dongyoung.bookstore.domain.Cart;
import kim.dongyoung.bookstore.domain.Order;
import kim.dongyoung.bookstore.domain.Refund;
import kim.dongyoung.bookstore.domain.Sales;
import kim.dongyoung.bookstore.domain.Shelf;
import kim.dongyoung.bookstore.presentation.Console;
import kim.dongyoung.bookstore.presentation.MenuImpl;

final public class GuestImpl extends MenuImpl implements Guest {
		static int number;

		//싱글톤으로 설정하여, 객체생성을 이곳에서 한번만 해주고, 
		//다른클래스에서 getInstance를 이용해 GuestImpl클래스의 메소드에 편리하게 접근가능하게 한다.
		static GuestImpl g =new GuestImpl();
		public static GuestImpl getInstance() {
			return g;
		}
		//맵 <key타입, value타입> 참조변수 = 해시맵 <key타입, value타입>(); 이고 다형성을 적용하였다.
		Map<String, String > a = new HashMap<String,String>(); 	// 기존 고객 로그인 정보, 회원가입 정보 축적
	//	private String addid; // 회원가입 메서드의 정보를 전역변수로 가져온다.
	//	private String addpw;
		
	@Override
	public void GestLogin() { //고객 로그인

			//콘솔로 입력받는다. 
			a.put("guest1", "1");
			a.put("guest2", "12");
			a.put("guest3", "123");
			a.put("guest4", "1234");
			a.put("guest5", "12345");
			
			while(true) {
				//콘솔로부터 입력받음
				System.out.println("고객 ID: ");
				String id =Console.stringInput();
				
				System.out.println("고객 PW: ");
				String pw =Console.stringInput();
				//a 해시맵의 키값중에 입력받은 (id)값이 있는가? 
				if(a.containsKey(id)) {
					// 압력받은 Key(id)가 그 key의 value(pw)값과 일치하는가?
					 if(a.get(id).equals(pw)) {//비밀번호 일치
						 System.out.println("==============================");
						 System.out.println("\t로그인 되었습니다^^*.");
						 System.out.println("===============================");
						 commonMenu(GUEST_MENU);//고객메뉴
						 break;//반복문을 빠져나간다.	
					 } else{
						 System.out.println("비밀번호가 일치하지 않습니다.");
					 } 
				 }else {//아이디가 없으면
					 System.out.println("입력하신 아이디가 존재하지 않습니다.");
				 }		
				}
		}
	@Override
	public void GestAdd() { // 고객 회원가입

		System.out.println("ID를 입력해주세요: ");
		String addid =Console.stringInput();
		
		System.out.println("PW를 입력해주세요: ");
		String addpw =Console.stringInput();
		
		System.out.println("회원가입이 완료되었습니다.");
		
		a.put(addid, addpw); // 입력한 정보를 담고 전역변수로 선언한 Map에 값이 담긴다.

		commonMenu(SHOP_LOGIN);
		
		
	}
	@Override
	public void cartList() { //장바구니 목록
		// TODO Auto-generated method stub
		while(true) {
			System.out.println("===============장바구니 목록===============");
			System.out.println("번호\t 도서명\t 저자\t 가격\t 수량\t ");
			//Cart클래스cart맵의 키와 값을 처음부터 끝까지 s맵에 담는다.
			for(Map.Entry<Integer, Book> s : Cart.cart.entrySet() ){
				System.out.print(s.getKey());
				System.out.println(s.getValue());
			}
			
			System.out.println("========================================");
			System.out.println("--------------장바구니 ----------------");
			System.out.println(" 1.추가 \t 2.삭제 \t 3.구매 \t4.이전 ");
			System.out.println("--------------------------------------");
			System.out.println("메뉴번호를 입력하세요. : ");
			
			while(true) {
				number = Console.intInput();
				switch(number) {
				case 4 :
					commonMenu(GUEST_MENU);//고객메뉴
					break;
				case 3 :
					commonMenu(GUEST_BUY);//고객 장바구니 구매
					break;
				case 2 :
					commonMenu(GUEST_CART_DEL);//고객 장바구니 삭제
					break;
				case 1 :
					commonMenu(GUEST_CART_ADD);
					break;
		}

			}}}

	@Override
	public void cartAdd() {//장바구니 추가
		// TODO Auto-generated method stub
		
		System.out.println("===============도서목록===============");
		System.out.println("번호\t 도서명\t 저자\t 가격\t 수량\t ");
		System.out.println("=====================================");
		//Shelf클래스book맵의 키와 값을 처음부터 끝까지 s맵에 담는다.
		for(Map.Entry<Integer, Book> s : Shelf.book.entrySet() ){
			System.out.print(s.getKey());
			System.out.println(s.getValue());
		}
		while(true){ 
			System.out.println("장바구니에 담을 책의 코드를 입력하세요. [이전 :0] : "); 
			int guestBookCode=Console.intInput();
		
			if (guestBookCode==0) {
			commonMenu(GUEST_WISH_LIST);//고객 장바구니 목록
			
			}else if(Shelf.book.containsKey(guestBookCode)) { //장바구니 추가 가능
				
				System.out.println("수량을 입력하세요. : ");
				int count =Console.intInput();//count 값을 입력받는다.
				while(true) {//Shelf클래스의 book맵에서 각각의 값을 불러서 대입한다.
					if(count<=Shelf.book.get(guestBookCode).getBookCount()) {
						String bookName= Shelf.book.get(guestBookCode).getBookName();
						String auther= Shelf.book.get(guestBookCode).getAuther();
						int bookPrice= Shelf.book.get(guestBookCode).getBookPrice();
						int bookCount= count;//bookCount의 값을 새로 입력받은 수량값으로 설정한다.
						//Cart에 설정값을 입력한다.
						Cart.cart.put(guestBookCode, new Book(guestBookCode,bookName,auther,bookPrice,bookCount));
						
						System.out.println("====================================");
						System.out.println("\t\t장바구니에 담겼습니다.");
						System.out.println("=====================================");
						break;
					}else {
						System.out.println("수량이 부족합니다.");
						break;
					}
				}
			
				
			}
		
		}}
		

	@Override
	public void cartDel() { //장바구니 삭제
		// TODO Auto-generated method stub
		try {
			
		while(true) {
			System.out.print("삭제하려는 책의 코드를 입력하세요. 이전[:0] : ");
			int guestBookCode = Console.intInput();
			
			if(guestBookCode==0) {
				commonMenu(GUEST_WISH_LIST);//장바구니목록
			
			}else if(Cart.cart.containsKey(guestBookCode)){
				while(true) {
					System.out.println("수량을 입력하세요. : ");
					int count =Console.intInput();
					if(count<=Cart.cart.get(guestBookCode).getBookCount()) {
						String bookName= Cart.cart.get(guestBookCode).getBookName();
						String auther= Cart.cart.get(guestBookCode).getAuther();
						int bookPrice= Cart.cart.get(guestBookCode).getBookPrice();
						int bookCount= Cart.cart.get(guestBookCode).getBookCount()-count;
						// 삭제할 수량의 수만큼을 카트의 수량 값에서 빼준다.
						
						Cart.cart.put(guestBookCode,new Book(guestBookCode,bookName,auther,bookPrice,bookCount));
				
						System.out.println("=====================================");
						System.out.println("\t목록에서 삭제 되었습니다.");
						System.out.println("=====================================");
						break;
					}else {
						System.out.println("수량이 부족합니다.");
						break;
					}	
				}
			}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	@Override
	public void nowBuy() { //즉시구매
		// TODO Auto-generated method stub
		System.out.println("===============도서목록===============");
		System.out.println("번호\t 도서명\t 저자\t 가격\t 수량\t ");
		System.out.println("=====================================");
		
		for(Map.Entry<Integer, Book> s : Shelf.book.entrySet() ){
			s.getKey();
			Book a =s.getValue();
			System.out.println(s.getKey()+""+a);
		}
		while(true) {
			System.out.print("구매할 책의 코드를 입력하세요. 이전[:0] : ");
			int guestBookCode = Console.intInput();

			if(guestBookCode==0) {
				commonMenu(GUEST_MENU);
				
			}else if(Shelf.book.containsKey(guestBookCode)){
				System.out.print("수량을 입력하세요. : " );
				int count =Console.intInput();
				while(true) {
					if(count<=Shelf.book.get(guestBookCode).getBookCount()) {
						String bookName= Shelf.book.get(guestBookCode).getBookName();
						String auther= Shelf.book.get(guestBookCode).getAuther();
						int bookPrice= Shelf.book.get(guestBookCode).getBookPrice();
						int bookCount= count;//입력받은 값을 수량값에 대입한다.
						//주문목록에 입력받은 키의 데이터들과 새롭게 입력받은 수량을 넣어준다
						Order.order.put(guestBookCode,new Book(guestBookCode,bookName,auther,bookPrice,bookCount));
						
						System.out.println("====================================");
						System.out.println("\t구매요청 되었습니다.");
						System.out.println("=====================================");
						break;
					}else {
						System.out.println("수량이 부족합니다.");
						break;
					}
				}}
		
	}}

	@Override
	public void buy() { //장바구니 구매
		// TODO Auto-generated method stub
		try{
			while(true) {
				System.out.print("구매할 책의 코드를 입력하세요. 이전[:0] : ");
				int guestBookCode= Console.intInput();
				
				if(guestBookCode==0) {
					commonMenu(GUEST_WISH_LIST);//장바구니목록
				
				}else if(Cart.cart.containsKey(guestBookCode)){
					
					System.out.print("수량을 입력하세요. : " );
					
					int count =Console.intInput();
					
					while(true) {
						if(count<=Cart.cart.get(guestBookCode).getBookCount()) {
							String bookName= Cart.cart.get(guestBookCode).getBookName();
							String auther= Cart.cart.get(guestBookCode).getAuther();
							int bookPrice= Cart.cart.get(guestBookCode).getBookPrice();
							int bookCount= count;
							//주문목록에 입력받은 키의 데이터들과 새롭게 입력받은 수량을 넣어준다.
							Order.order.put(guestBookCode,new Book(guestBookCode,bookName,auther,bookPrice,bookCount));
							
							System.out.println("====================================");
							System.out.println("\t구매요청 되었습니다.");
							System.out.println("=====================================");
							break;
						}else {
							System.out.println("수량이 부족합니다.");
							break;
						}
					}
			}
	}
		}catch(Exception e){
			
		}
		System.out.println("=====================================");
		System.out.println("\t구매요청 되었습니다.");
		System.out.println("=====================================");
		
}

	@Override
	public void refund() { //고객환불
		// TODO Auto-generated method stub
		System.out.println("=============구매완료 목록===============");
		System.out.println("번호\t 도서명\t 저자\t 가격\t 수량\t ");
		System.out.println("=====================================");
		
		for(Map.Entry<Integer,Book> s : Sales.sales.entrySet()) {
			System.out.print(s.getKey());
			System.out.println(s.getValue());
		}
		while(true) {
			System.out.print("환불요청할 책의 코드를 입력하세요. 이전[:0] : ");
			int guestBookCode = Console.intInput();
				if(guestBookCode==0) {
					commonMenu(GUEST_MENU);//관리자 주문관리	
				}else if(Shelf.book.containsKey(guestBookCode)){//일치하는 키값이 있는가?
					Refund.refund.put(guestBookCode,Sales.sales.get(guestBookCode));
					// 환불에 입력받은 키값과 그 데이터를 집어넣는다.
				
					System.out.println("=====================================");
					System.out.println("\t환불 요청 되었습니다.");
					System.out.println("=====================================");	
				}
		}
		
	}
	


	



}
