package kim.dongyoung.bookstore.presentation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import kim.dongyoung.bookstore.domain.Code;

public class Console extends MenuImpl   implements Code{ 
	
	private static BufferedReader reader;
	
	public void Console() {
		commonMenu(SHOP_LOGIN ); 
		
	}
	
	//콘솔에 문자형 입력값을 입력받을때 스캐너를 생성자를 이용할 필요가 없다. 접근법은 Consol.stringInput이다. try catch 문을 이용하여 오류처리.
	public static String stringInput() { 
		reader = new BufferedReader(new InputStreamReader(System.in));
		//Scanner reader = new Scanner(System.in);
		String str ="";
		
		try {
			str = reader.readLine(); //입력받은 값을 읽어들여서 str변수에 대입.
		} catch (IOException e) {  //입출력 예외로 잡아준다.
			System.out.println("키보드 에러");
			}finally {
				
			}
		return str; //입력값을 돌려준다.
	}


	public static int intInput() { //콘솔에 정수형 입력값을 입력받을때 스캐너를 생성자를 이용할 필요가 없다. 접근법은 Consol.intInput이다. try catch 문을 이용하여 오류처리.
		reader = new BufferedReader(new InputStreamReader(System.in));
		//Scanner reader = new Scanner(System.in);
		String str ="";
		int i = 0;
		
		try {
			str = reader.readLine(); // 입력한 값을 읽어들여서 str변수에 대입.
			i =Integer.parseInt(str);
		} catch (IOException e) {
			System.out.println("키보드 에러");
			}finally {
				
			}
		return i; //입력값을 돌려준다.
	}


}
