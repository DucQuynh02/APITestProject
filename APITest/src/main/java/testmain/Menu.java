package testmain;
import static io.restassured.RestAssured.baseURI;

import java.util.Scanner;

import autotest.Constant;
import autotest.LoginTest;

public class Menu {

	
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	int luachon=0;
 
	do{
		System.out.println("----------Mời chọn chức năng :----------");
		System.out.println("1: Chọn lựa đường link base URL");
		System.out.println("2: Chọn lựa API cần kiểm thử tự động");
		System.out.println("3: Chạy từng unit test case hay tất cả unit test của một API");
		System.out.println("0: Thoát.");
		luachon= sc.nextInt();
		sc.nextLine();
		if(luachon==1) {
			System.out.println("Chọn lựa đường link base URL:");
			String url = sc.nextLine();
			if(!url.isEmpty() ) Constant.BaseURL = url; 
			else Constant.BaseURL = "https://auctions-app-2.herokuapp.com/api"; 
			System.out.println("Base URL là: "+Constant.BaseURL);
			
		}
		else if(luachon==2) {	
			System.out.println("Chọn lựa API cần kiểm thử tự động");
			API api = new API();
			api.menuAPI();
		}
		else if(luachon==3) {
			System.out.println("Chạy từng unit test case hay tất cả unit test của một API");
			ChooseTest chTest = new ChooseTest();
			chTest.menuTest();
		}
		else  {
			System.out.println("Thoát chương trình");
			break;
		}
	} while(luachon!=0);
	
}
}

