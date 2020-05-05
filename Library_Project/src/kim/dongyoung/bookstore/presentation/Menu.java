package kim.dongyoung.bookstore.presentation;

public interface Menu {
	
	public void commonMenu(int menu);//메뉴공통
	public void loginMenu();//로그인메뉴
	public void hostMenu();//관리자메뉴
	public void hostStockMenu();//관리자재고메뉴 클릭하면(책 추가 수정 삭제) // 메소드 구현부분은 host의 bookList(); 메소드로 호출 (싱글톤으로)
	//클래스명. get인스턴스.bookAdd();
	public void hostOrderMenu();//관리자주문매뉴
	public void guestMenu();//고객메뉴
	public void guestCartMenu();//고객 장바구니
	

}
