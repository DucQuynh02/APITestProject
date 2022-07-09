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


public class ChooseTest {
	public void menuTest() {
		Scanner sc= new Scanner(System.in) ;
		int luachonAPI = Constant.luachonAPI;
		int luachonTest;

		if(luachonAPI==1) {
			System.out.println("API: Login");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: Login test 1: The email or password is incorrect ");
			System.out.println("2: Login test 2: The email is empty");
			System.out.println("3: Login test 3: The email and password are correct");
			System.out.println("4: Login test 4: The email is the wrong format");
			System.out.println("5: Login test 5: The email is more than 255 characters");
			System.out.println("6: Login test 6: The password is null");
			System.out.println("7: Login test 7: The password is more than 255 characters");
			luachonTest = sc.nextInt();
			sc.nextLine();
			LoginTest lgt = new LoginTest();
			if(luachonTest==0) {
			lgt.Login1();
			lgt.Login2();
			lgt.Login3();
			lgt.Login4();
			lgt.Login5();
			lgt.Login6();
			lgt.Login7();
			}
			else if(luachonTest==1) {
				lgt.Login1();
				}
			else if(luachonTest==2) {
				lgt.Login2();
				}
			else if(luachonTest==3) {
				lgt.Login3();
				}
			else if(luachonTest==4) {
				lgt.Login4();
				}
			else if(luachonTest==5) {
				lgt.Login5();
				}
			else if(luachonTest==6) {
				lgt.Login6();
				}
			else if(luachonTest==7) {
				lgt.Login7();
				}
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
			System.out.println("API: Get List Auctions by Status ");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: Get list auctions by status test 1: Correct data ");
			System.out.println("2: Get list auctions by status test 2: index null");
			System.out.println("3: Get list auctions by status test 3: count null");
			System.out.println("4: Get list auctions by status test 4: Log in");
			System.out.println("5: Get list auctions by status test 5: Outdate token");
			System.out.println("6: Get list auctions by status test 6: Status: đã bán");
			System.out.println("7: Get list auctions by status test 7: Status Id is not exist");
			luachonTest = sc.nextInt();
			sc.nextLine();
			ListAuctionStatusTest las = new ListAuctionStatusTest();
			if(luachonTest==0) {
				las.LAS1();
				las.LAS2();
				las.LAS3();
				las.LAS4();
				las.LAS5();
				las.LAS6();
				las.LAS7();
			}
			else if(luachonTest==1) {
				las.LAS1();
				}
			else if(luachonTest==2) {
				las.LAS2();
				}
			else if(luachonTest==3) {
				las.LAS3();
				}
			else if(luachonTest==4) {
				las.LAS4();
				}
			else if(luachonTest==5) {
				las.LAS5();
				}
			else if(luachonTest==6) {
				las.LAS6();
				}
			else if(luachonTest==7) {
				las.LAS7();
				}		
			
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
			EditAuction editAuc = new EditAuction();
			editAuc.EditAuction1();
			editAuc.EditAuction2();
			
		}
		else if(luachonAPI==12) {	
			System.out.println("12: Create Item ");


			
		}
		else if(luachonAPI==13) {
			System.out.println("13: Create Comment");
			CreateComment crtcmt = new CreateComment();
			crtcmt.test1();
		}
		else if(luachonAPI==14) {
			System.out.println("14: Get List Comment");
			
			
		}
		else if(luachonAPI==15) {
			System.out.println("15: Create Bid");
			
		}
		else if(luachonAPI==16) {
			System.out.println("16: Get List Bids");
			GetListBids getListBids = new GetListBids();
			getListBids.ListBids1();
			getListBids.ListBids2();
			getListBids.ListBids3(); 
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
			LikeAuction likeAuc = new LikeAuction();
			likeAuc.likeAuction1();
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
			GetNotifications getNotifi = new GetNotifications();
			getNotifi.getNoti1();
			getNotifi.getNoti2(); 
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

