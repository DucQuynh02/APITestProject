package testmain;

import java.util.Scanner;

import autotest.Constant;
import autotest.CreateComment;
import autotest.EditAuction;
import autotest.GetListBids;
import autotest.GetNotifications;
import autotest.LikeAuction;
import autotest.ListAuctionStatusTest;
import autotest.LoginTest;


public class API {
	public void menuAPI() {
		Scanner sc= new Scanner(System.in) ;
		int luachonAPI = 0 ;
			System.out.println("----------Mời chọn API :----------");
			System.out.println("1: Login ");
			System.out.println("2: Sign Up ");
			System.out.println("3: Edit Account");
			System.out.println("4: Log Out");
			System.out.println("5: Get list Auctions");
			System.out.println("6: Get List Auctions By Status");
			System.out.println("7: Get List Auctions By User");
			System.out.println("8: Get List Auctions By Type");
			System.out.println("9: Get Detail Auction");
			System.out.println("10: Create Auction ");
			System.out.println("11: Edit Auction ");
			System.out.println("12: Create Item ");
			System.out.println("13: Create Comment");
			System.out.println("14: Get List Comment");
			System.out.println("15: Create Bid");
			System.out.println("16: Get List Bids");
			System.out.println("17: Get List CateGoires");
			System.out.println("18: Get List Brands");
			System.out.println("19: Accept Max Bid");
			System.out.println("20: Contact Us");
			System.out.println("21: Like Auction");
			System.out.println("22: Get List Likes");
			System.out.println("23: Total Likes Of Auction");
			System.out.println("24: Get News");
			System.out.println("25: Read New");
			System.out.println("26: Get Notifications");
			System.out.println("27: Read Notifications");
			System.out.println("28: Get Slider");
			System.out.println("29: Search");
			System.out.println("30: Delete Comment");
			System.out.println("0: Thoát.");
			luachonAPI= sc.nextInt();
			Constant.luachonAPI =luachonAPI;
			sc.nextLine();
			if(luachonAPI==1) {
				System.out.println("1: Login");
			
			}
			else if(luachonAPI==2) {	
				System.out.println("2: Sign Up");

			}
			else if(luachonAPI==3) {
				System.out.println("3: Edit Account");
			}
			else if(luachonAPI==4) {
				System.out.println("4: Logout");
			}
			else if(luachonAPI==5) {
				System.out.println("5: Get List Auctions");
				
			}
			else if(luachonAPI==6) {
				System.out.println("6: Get List Auctions By Status");				

			}
			else if(luachonAPI==7) {
				System.out.println("7: Get List Auctions By User");

			}
			else if(luachonAPI==8) {
				System.out.println("8: Get List Auctions By Type");
				
				
			}
			else if(luachonAPI==9) {
				System.out.println("9: Get Detail Auction");
			}
			else if(luachonAPI==10) {
				System.out.println("10: Create Auction ");
				
			}
			else if(luachonAPI==11) {
				System.out.println("11: Edit Auction ");

				
			}
			else if(luachonAPI==12) {	
				System.out.println("12: Create Item ");


				
			}
			else if(luachonAPI==13) {
				System.out.println("13: Create Comment");
				CreateComment crtcmt =new CreateComment();
				crtcmt.test1();
				crtcmt.test2();
				
			}
			else if(luachonAPI==14) {
				System.out.println("14: Get List Comment");
				
				
			}
			else if(luachonAPI==15) {
				System.out.println("15: Create Bid");
				
			}
			else if(luachonAPI==16) {
				System.out.println("16: Get List Bids");

			}
			else if(luachonAPI==17) {
				System.out.println("17: Get List CateGoires");
				
			}
			else if(luachonAPI==18) {
				System.out.println("18: Get List Brands");
				
				
			}
			else if(luachonAPI==19) {
				System.out.println("19: Accept Max Bid");
				
				
			}
			else if(luachonAPI==20) {
				System.out.println("20: Contact Us");
			}
			else if(luachonAPI==21) {
				System.out.println("21: Like Auction");

			}
			else if(luachonAPI==22) {	
				System.out.println("22: Get List Likes");
				
			}
			else if(luachonAPI==23) {
				System.out.println("23: Total Likes Of Auction");
			}
			else if(luachonAPI==24) {
				System.out.println("24: Get News");
			}
			else if(luachonAPI==25) {
				System.out.println("25: Read New");
				
			}
			else if(luachonAPI==26) {
				System.out.println("26: Get Notifications");

			}
			else if(luachonAPI==27) {
				System.out.println("27: Read Notifications");
				
				
			}
			else if(luachonAPI==28) {
				System.out.println("28: Get Slider");
		
				
			}
			else if(luachonAPI==29) {
				System.out.println("29: Search");

	
			}
			else if(luachonAPI==30) {
				System.out.println("30: Delete Comment");
			}
			else  {
				System.out.println("Lựa chọn lỗi");			
			}

	}
}
