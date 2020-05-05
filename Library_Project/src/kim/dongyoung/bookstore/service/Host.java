package kim.dongyoung.bookstore.service;

public interface Host {
	
	//public static final String ID="host";
	//public static final String PASSWORD="host1234";
	
	public void HostLogin();// 주인 로그인
	
	public void bookList();//책목록
	public void bookAdd();//책추가
	public void bookUpdate();//책수정
	public void bookDel();//책삭제

	public void orderList();//주문목록
	public void orderConfirm();//결제승인
	public void orderCancel();//결제취소
	public void saleTotal();//결산

}
