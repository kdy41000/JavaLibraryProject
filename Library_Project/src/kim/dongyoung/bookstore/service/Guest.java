package kim.dongyoung.bookstore.service;

public interface Guest {
	
	public void GestLogin(); //고객 로그인
	public void GestAdd(); //고객 회원가입
	
	public void cartList();//장바구니 리스트
	public void cartAdd();//장바구니 담기
	public void cartDel();//장바구니 삭제
	
	public void nowBuy();//바로구매
	public void buy();//구매
	public void refund();//환불
	

}
