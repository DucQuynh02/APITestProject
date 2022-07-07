package testmain;

import java.util.Scanner;
import autotest.CreateComment;
import autotest.EditAuction;
import autotest.GetListBids;
import autotest.ListAuctionStatusTest;
import autotest.LoginTest;
import autotest.SignUpTest;

public class API {
	public void menuAPI() {
		Scanner sc= new Scanner(System.in) ;
		int luachon;
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
			luachon= sc.nextInt();
			sc.nextLine();
			if(luachon==1) {
				System.out.println("1: Login");
				LoginTest lgt = new LoginTest();
				lgt.Login1();
				lgt.Login2();
				lgt.Login3();
				
			}
			else if(luachon==2) {	
				System.out.println("2: Sign Up");
				SignUpTest.SignUp1();
			}
			else if(luachon==3) {
				System.out.println("3: Edit Account");
			}
			else if(luachon==4) {
				System.out.println("4: Logout");
			}
			else if(luachon==5) {
				System.out.println("5: Get List Auctions By Status");
				
			}
			else if(luachon==6) {
				System.out.println("6: Get List Auctions By Status");				
				ListAuctionStatusTest las = new ListAuctionStatusTest();
				las.LAS1();
				las.LAS2();
				las.LAS3();
			}
			else if(luachon==7) {
				System.out.println("7: Get List Auctions By User");

			}
			else if(luachon==8) {
				System.out.println("8: Get List Auctions By Type");
				
				
			}
			else if(luachon==9) {
				System.out.println("9: Get Detail Auction");
			}
			else if(luachon==10) {
				System.out.println("10: Create Auction ");
				
			}
			else if(luachon==11) {
				System.out.println("11: Edit Auction ");
				EditAuction editAuc = new EditAuction();
				editAuc.EditAuction1();

				
			}
			else if(luachon==12) {	
				System.out.println("12: Create Item ");


				
			}
			else if(luachon==13) {
				System.out.println("13: Create Comment");
				CreateComment crtcmt = new CreateComment();
				crtcmt.test1();
			}
			else if(luachon==14) {
				System.out.println("14: Get List Comment");
				
				
			}
			else if(luachon==15) {
				System.out.println("15: Create Bid");
				
			}
			else if(luachon==16) {
				System.out.println("16: Get List Bids");
				GetListBids getListBids = new GetListBids();
				getListBids.ListBids1();
				 
			}
			else if(luachon==17) {
				System.out.println("17: Get List CateGoires");
				
			}
			else if(luachon==18) {
				System.out.println("18: Get List Brands");
				
				
			}
			else if(luachon==19) {
				System.out.println("19: Accept Max Bid");
				
				
			}
			else if(luachon==20) {
				System.out.println("20: Contact Us");
			}
			else if(luachon==21) {
				System.out.println("21: Like Auction");
				
			}
			else if(luachon==22) {	
				System.out.println("22: Get List Likes");
				
			}
			else if(luachon==23) {
				System.out.println("23: Total Likes Of Auction");
			}
			else if(luachon==24) {
				System.out.println("24: Get News");
			}
			else if(luachon==25) {
				System.out.println("25: Read New");
				
			}
			else if(luachon==26) {
				System.out.println("26: Get Notifications");
				
				 
			}
			else if(luachon==27) {
				System.out.println("27: Read Notifications");
				
				
			}
			else if(luachon==28) {
				System.out.println("28: Get Slider");

								
				
			}
			else if(luachon==29) {
				System.out.println("29: Search");

	
			}
			else if(luachon==30) {
				System.out.println("30: Delete Comment");
			}
			else  {
				System.out.println("Lựa chọn lỗi");			
			}

	}
}
