package kim.dongyoung.bookstore.presentation;

import java.util.Scanner;

import kim.dongyoung.bookstore.domain.Code;
import kim.dongyoung.bookstore.service.GuestImpl;
import kim.dongyoung.bookstore.service.HostImpl;
import kim.dongyoung.bookstore.*;
import kim.dongyoung.bookstore.presentation.Console;

public class MenuImpl implements Menu , Code {// 인터페이스 클래스인 Code 클래스와 Menu 클래스를 상속받아 비어있는 상속내용을 꼭 채워줘야 한다.  

	static Console con = new Console();

	static int number;
	
	CountExit cte = new CountExit(); // 종료 시 카운트를 위한 객체 생성
	Thread t = new Thread(cte);
	
	public void commonMenu(int menu) { //상수이용의 장점 : 숫자로 되어있는 값을 해석가능한 상수로 설정해주어 사용시 편리함을 준다.
		//(예를들어 원래는 로그인시 Code의 999가 입력됨)
		
		switch(menu) {
	case SHOP_LOGIN ://로그인
		loginMenu();
	
	case HOST_MENU ://관리자메뉴
		hostMenu();
		break;
	case HOST_STOCK_MENU ://관리자 재고 관리
		hostStockMenu();
	break;
	case HOST_BOOK_LIST : //관리자 도서 목록
		HostImpl.getInstance().bookList();
		//bookList();
	break;
	case HOST_BOOK_ADD ://관리자 도서 추가
		HostImpl.getInstance().bookAdd();
	break;
	case HOST_BOOK_UPDATE://관리자 도서 수정
		HostImpl.getInstance().bookUpdate();
	break;
	case HOST_BOOK_DEL://관리자 도서 삭제
		HostImpl.getInstance().bookDel();
	break;
	
	
	case HOST_ORDER_MENU ://관리자 주문 관리
		 hostOrderMenu();
	break;
	case HOST_ORDER_LIST ://관리자 주문 목록
		HostImpl.getInstance().orderList();
	break;
	case HOST_ORDER_CONFIRM://관리자 결제승인
		HostImpl.getInstance().orderConfirm() ;
	break;
	case HOST_ORDER_CANCEL:// 관리자 결제취소
		HostImpl.getInstance().orderCancel();
	break;
	case HOST_SALE_TOTAL://관리자 결산
		HostImpl.getInstance().saleTotal();
	break;
	
	
	case GUEST_MENU://고객메뉴
		guestMenu();
	break;
	case GUEST_WISH_LIST://고객 장바구니 목록
		GuestImpl.getInstance().cartList();
	break;
	case GUEST_CART_ADD://고객 장바구니 추가
		GuestImpl.getInstance().cartAdd(); 
	break;
	case GUEST_CART_DEL://고객 장바구니 삭제
		GuestImpl.getInstance().cartDel();
		break;
	
	
	case GUEST_BUY: //고객 구매
		GuestImpl.getInstance().buy(); 
		break;
	case GUEST_NOWBUY://고객 바로 구매
		GuestImpl.getInstance().nowBuy();
		break;
	case GUEST_ORDER_LIST://고객 주문목록
		
		break;
	case GUEST_REFUND://고객 환불
		GuestImpl.getInstance().refund();
		break;
		
		}
	}


	@Override
	public void loginMenu() {//로그인
		System.out.println("---------------------로그인----------------------");		
		System.out.println("1.고객"+"\t2.관리자"+"\t 3.고객 회원가입"+"\t4.종료");
		System.out.println("------------------------------------------------");
		System.out.print("메뉴번호를 입력하세요. :");
	
		try {
			while(true) {
				
			number = Console.intInput();
			switch(number) {
			case 4 :
				t.start(); // 종료 시 카운트를 하기 위한 스레드 기능이 있는 메서드를 호출한다.				
				break;
			case 3 :
				 GuestImpl.getInstance().GestAdd(); // 회원가입 클래스
				break;
			case 2 :
				HostImpl.getInstance().HostLogin();//HostImpl클래스를 싱글톤으로 설정하여,
				//HostImpl클래스에 들어있는 HostLogin()메소드값을 getInstance()를 이용해 받아온다. 
				break;
			case 1 :
				GuestImpl.getInstance().GestLogin();
				break;
				}
			}
		} catch (Exception e) {
			System.out.println("키보드 에러");
		}
		
		}


	


	@Override
	public void hostMenu() {//관리자메뉴

		System.out.println("-------------------관리자 메뉴--------------------");		
		System.out.println("1.재고관리"+"\t2.주문관리"+"\t 3.로그아웃");
		System.out.println("------------------------------------------------");
		System.out.print("메뉴번호를 입력하세요. :");
		
		try {
		while(true) {
			number = Console.intInput();
			switch(number) {
			case 3 :
				loginMenu();
				break;
			case 2 :
				hostOrderMenu();
				break;
			case 1 :
				hostStockMenu();
				break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		}


	@Override
	public void hostStockMenu() { //관리자 재고관리
		System.out.println("------------------관리자 재고관리--------------------");		
		System.out.println("1.목록"+"\t2.추가"+"\t 3.수정"+"\t4.삭제"+"\t5.이전");
		System.out.println("------------------------------------------------");
		System.out.print("메뉴번호를 입력하세요. :");
	
		try {
		while(true) {
			number = Console.intInput();
			switch(number) {
			case 5 :
				commonMenu(HOST_MENU);
				break;
			case 4 :
				commonMenu(HOST_BOOK_DEL);
				break;
			case 3 :
				commonMenu(HOST_BOOK_UPDATE);
				break;
			case 2 :
				commonMenu(HOST_BOOK_ADD);
				break;
			case 1 :
				commonMenu(HOST_BOOK_LIST);
				break;
				default:
					break;
					}
			}
		} catch (Exception e) {
		e.printStackTrace();
	}
	}
	

   


	@Override
	public void hostOrderMenu() { //주문관리
		System.out.println("---------------------주문관리----------------------");		
		System.out.println("1.주문목록"+"\t2.결제승인"+"\t 3.결제취소"+"\t4.결산"+"\t5.이전");
		System.out.println("------------------------------------------------");
		System.out.print("메뉴번호를 입력하세요. :");

		try {
		while(true) {
			number = Console.intInput();
			switch(number) {
			case 5 :
				commonMenu(HOST_MENU);
				break;
			case 4 : 
				commonMenu(HOST_SALE_TOTAL );
				break;
			case 3 :
				commonMenu(HOST_ORDER_CANCEL);
				break;
			case 2 :
				commonMenu(HOST_ORDER_CONFIRM);
				break;
			case 1 :
				commonMenu(HOST_ORDER_LIST );
				break;
				
				default:
					break;
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	@Override
	public void guestMenu() { //고객메뉴
		System.out.println("---------------------고객메뉴----------------------");		
		System.out.println("1.장바구니"+"\t2.구매"+"\t 3.환불"+"\t4.로그아웃");
		System.out.println("------------------------------------------------");
		System.out.print("메뉴번호를 입력하세요. :");
		
		try {
		while(true) {
			number = Console.intInput();
			switch(number) {
			case 4 : 
				commonMenu(SHOP_LOGIN );
				break;
			case 3 :
				commonMenu(GUEST_REFUND);
				break;
			case 2 :
				commonMenu(GUEST_NOWBUY );
				break;
			case 1 :
				commonMenu(GUEST_WISH_LIST);
				break;
				
				default:
					break;
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	@Override
	public void guestCartMenu() { //장바구니
		System.out.println("---------------------장바구니----------------------");		
		System.out.println("1.추가"+"\t2.삭제"+"\t 3.구매"+"\t4.이전");
		System.out.println("------------------------------------------------");
		System.out.print("메뉴번호를 입력하세요. :");
		
		try {
		while(true) {
			number = Console.intInput();
			switch(number) {
			case 4 : 
				commonMenu(GUEST_MENU );
				break;
			case 3 :
				commonMenu(GUEST_BUY);
				break;
			case 2 :
				commonMenu(GUEST_CART_DEL);
				break;
			case 1 :
				commonMenu(GUEST_CART_ADD );
				break;
				
				default:
					break;
					}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}			
}


