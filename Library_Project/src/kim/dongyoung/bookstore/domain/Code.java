package kim.dongyoung.bookstore.domain;

public interface Code {
	// 화면 메뉴들이 999, 100,등등이 있다. 그러나 번호를 외우고 다닐수가 없기에 한글로 목록을 만들어준것.
	//상수는 가독성을 높이기 위해서 
	static final int SHOP_LOGIN = 999;//로그인
	static final int HOST_MENU = 100; //관리자 메뉴
	static final int HOST_STOCK_MENU =110; //관리자 재고관리
	static final int HOST_BOOK_LIST = 111; //관리자 도서목록
	static final int HOST_BOOK_ADD = 112; //관리자 도서추가
	static final int HOST_BOOK_UPDATE = 113; //관리자 도서 수정
	static final int HOST_BOOK_DEL = 114; //관리자 도서 삭제
	
	static final int HOST_ORDER_MENU =120; //관리자 주문관리
	static final int HOST_ORDER_LIST =121; //관리자 주문목록
	static final int HOST_ORDER_CONFIRM =122; //관리자 결제승인
	static final int HOST_ORDER_CANCEL =123; //관리자 결제취소
	
	static final int HOST_SALE_TOTAL =124; //관리자 결산
	
	static final int GUEST_MENU=200; //고객 메뉴
	static final int GUEST_WISH_LIST=210; //고객 장바구니 목록
	static final int GUEST_CART_ADD=211; //고객 장바구니 추가
	static final int GUEST_CART_DEL=212; //고객 장바구니 삭제
	static final int GUEST_BUY=213; //고객 구매
	//고객 장바구니 삭제	
	static final int GUEST_NOWBUY=220; // 고객 바로구매
	static final int GUEST_ORDER_LIST=221; //고객 주문목록
	static final int GUEST_REFUND=230; //고객 환불
	
	
}
