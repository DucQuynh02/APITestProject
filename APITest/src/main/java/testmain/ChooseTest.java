package testmain;

import java.util.Scanner;

import autotest.Constant;
import autotest.ContactUsTest;
import autotest.CreatItem;
import autotest.CreateAuctionsTest;
import autotest.CreateBidsTest;
import autotest.CreateComment;
import autotest.DeletecommentTest;
import autotest.EditAuction;
import autotest.GetListBids;
import autotest.GetNotifications;
import autotest.LikeAuction;
import autotest.ListAuctionStatusTest;
import autotest.LoginTest;
import autotest.Search;
import autotest.EditAccount;
import autotest.GetListAuctionByType;
import autotest.CreateComment;
import autotest.GetListBrands;
import autotest.GetSlider;
import autotest.TotalLikesOfAuction;
import autotest.get_list_auctions;
import autotest.readnewTest;
import autotest.LogoutTest;
import autotest.GetListComments;
import autotest.GetNews;
import autotest.GetDetailAuction;
import autotest.AcceptMaxBid;
import autotest.SignUp;
import autotest.ListAuctionByUser;
import autotest.GetListCategoires;
import autotest.GetListLikes;
import autotest.ReadNotifications;

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
			System.out.println("API: SignUp");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: SignUp test 1: The All is incorrect ");
			System.out.println("2: SignUp test 2: The email is more than 255 characters");
			System.out.println("3: SignUp test 3: The email even null ");
			System.out.println("4: SignUp test 4: The phone is more than 60 characters ");
			System.out.println("5: SignUp test 5: The phone even null");
			System.out.println("6: SignUp test 6: The address is more than 255 characters");
			System.out.println("7: SignUp test 7: The phone is not enter");
			System.out.println("8: SignUp test 8: The name is more than 255 characters");
			System.out.println("9: SignUp test 9: The name is not enter");
			System.out.println("10: SignUp test 10: The name even null ");
			System.out.println("11: SignUp test 11: The password even null");
			System.out.println("12: SignUp test 12: The password is more than 255 characters");
			System.out.println("13: SignUp test 13: The repassword even null");
			System.out.println("14: SignUp test 14: The repassword is diffirent from password");
			System.out.println("15: SignUp test 15: The repassword is more than 255 characters");
			System.out.println("16: SignUp test 16: The email is exist");
			luachonTest = sc.nextInt();
			sc.nextLine();
			SignUp sg= new SignUp();
			if(luachonTest==0) {
			sg.SignUp1();
			sg.SignUp2();
			sg.SignUp3();
			sg.SignUp4();
			sg.SignUp5();
			sg.SignUp6();
			sg.SignUp7();
			sg.SignUp8();
			sg.SignUp9();
			sg.SignUp10();
			sg.SignUp11();
			sg.SignUp12();
			sg.SignUp13();
			sg.SignUp14();
			sg.SignUp15();
			sg.SignUp16();
			}
			else if(luachonTest==1) {
				sg.SignUp1();
				}
			else if(luachonTest==2) {
				sg.SignUp2();
				}
			else if(luachonTest==3) {
				sg.SignUp3();
				}
			else if(luachonTest==4) {
				sg.SignUp4();
				}
			else if(luachonTest==5) {
				sg.SignUp5();
				}
			else if(luachonTest==6) {
				sg.SignUp6();
				}
			else if(luachonTest==7) {
				sg.SignUp7();
				}
			else if(luachonTest==8) {
				sg.SignUp8();
				}
			else if(luachonTest==9) {
				sg.SignUp9();
				}
			else if(luachonTest==10) {
				sg.SignUp10();
				}
			else if(luachonTest==11) {
				sg.SignUp11();
				}
			else if(luachonTest==12) {
				sg.SignUp12();
				}
			else if(luachonTest==13) {
				sg.SignUp13();
				}
			else if(luachonTest==14) {
				sg.SignUp14();
				}
			else if(luachonTest==15) {
				sg.SignUp15();
				}
			else if(luachonTest==16) {
				sg.SignUp16();
				}
			

		}
			else if(luachonAPI==3) {
			System.out.println("3: Edit Account");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: Edit Account test 1: Chỉnh sửa tài khoản thành công");
			System.out.println("2: Edit Account test 2: Name null");
			System.out.println("3: Edit Account test 3: Name: nhập quá 255 kí tự");
			System.out.println("4: Edit Account test 4: Phone: nhập quá 60 kí tự");
			System.out.println("5: Edit Account test 5: Phone null");
			System.out.println("6: Edit Account test 6: Address: nhập quá 255 kí tự");
			System.out.println("7: Edit Account test 7: Address null");
			System.out.println("8: Edit Account test 8: Email đã tồn tại");
			System.out.println("9: Edit Account test 9: Email sai định dạng");
			System.out.println("10: Edit Account test 10: Email nhập quá 255 kí tự");
			System.out.println("11: Edit Account test 11: Email null");
			System.out.println("12: Edit Account test 12: Pass null");
			System.out.println("13: Edit Account test 13: Pass: nhập quá 255 kí tự");
			System.out.println("14: Edit Account test 14: Re_pass null");
			System.out.println("15: Edit Account test 15: Re_pass không trùng pass");
			System.out.println("16: Edit Account test 16: Re_pass: nhập quá 255 kí tự");
			
			luachonTest = sc.nextInt();
			sc.nextLine();
			EditAccount test = new EditAccount();
			if(luachonTest==0) {
			test.test1();
			test.test2();
			test.test3();
			test.test4();
			test.test5();
			test.test6();
			test.test7();
			test.test8();
			test.test9();
			test.test10();
			test.test11();
			test.test12();
			test.test13();
			test.test14();
			test.test15();
			test.test16();
			
			}
			else if(luachonTest==1) {
				test.test1();
				}
			else if(luachonTest==2) {
				test.test2();
				}
			else if(luachonTest==3) {
				test.test3();
				}
			else if(luachonTest==4) {
				test.test4();
				}
			else if(luachonTest==5) {
				test.test5();
				}
			else if(luachonTest==6) {
				test.test6();
				}
			else if(luachonTest==7) {
				test.test7();
				}
			else if(luachonTest==8) {
				test.test8();
			        }
			else if(luachonTest==9) {
				test.test9();
				}
			else if(luachonTest==10) {
				test.test10();
				}
			else if(luachonTest==11) {
				test.test11();
				}
			else if(luachonTest==12) {
				test.test12();
				}
			else if(luachonTest==13) {
				test.test13();
				}
			else if(luachonTest==14) {
				test.test14();
				}
			else if(luachonTest==15) {
				test.test15();
				}
			else if(luachonTest==16) {
				test.test16();
				}
		}
		else if(luachonAPI==4) {
			System.out.println("4: Logout");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("1: Logout test 1: ");
			luachonTest = sc.nextInt();
			sc.nextLine();
			LogoutTest lt = new LogoutTest();
			if(luachonTest==1) {
				lt.Logout1();
			}
			
		}
		else if(luachonAPI==5) {
			System.out.println("5: Get List Auctions");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: List auctions test 1: all auctions ");
			System.out.println("2: List auctions test 2: auction going on");
			System.out.println("3: List auctions test 3: auction coming up");
			System.out.println("4: List auctions test 4: auction end");
			System.out.println("5: List auctions test 5: auction waiting");
			System.out.println("6: List auctions test 6: auction deny");
			System.out.println("7: List auctions test 7: auction sell success");
			luachonTest = sc.nextInt();
			sc.nextLine();
			get_list_auctions test = new get_list_auctions();
			if(luachonTest==0) {
			test.Test1();
			test.Test2();
			test.Test3();
			test.Test4();
			test.Test5();
			test.Test6();
			test.Test7();
			}
			else if(luachonTest==1) {
				test.Test1();
				}
			else if(luachonTest==2) {
				test.Test2();
				}
			else if(luachonTest==3) {
				test.Test3();
				}
			else if(luachonTest==4) {
				test.Test4();
				}
			else if(luachonTest==5) {
				test.Test5();
				}
			else if(luachonTest==6) {
				test.Test6();
				}
			else if(luachonTest==7) {
				test.Test7();
				}
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
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: List auctions by user test 1: correct data ");
			System.out.println("2: List auctions by user test 2: random StatusID");
			System.out.println("3: List auctions by user test 3: not Logged");
			luachonTest = sc.nextInt();
			sc.nextLine();
			ListAuctionByUser lau = new ListAuctionByUser();
			if(luachonTest==0) {
			lau.ListAuctionByUser1();
			lau.ListAuctionByUser2();
			lau.ListAuctionByUser3();
			}
			else if(luachonTest==1) {
				lau.ListAuctionByUser1();
				}
			else if(luachonTest==2) {
				lau.ListAuctionByUser2();
				}
			else if(luachonTest==3) {
				lau.ListAuctionByUser3();
				}

		}
				else if(luachonAPI==8) {
		System.out.println("8: Get List Auction By Type");
		System.out.println("----------Mời chọn Test Case :----------");
		System.out.println("0: All unit test ");
		System.out.println("1: Get List Auction By Type test 1: Correct data ");
		System.out.println("2: Get List Auction By Type test 2: index null");
		System.out.println("3: Get List Auction By Type test 3: count null");
		System.out.println("4: Get List Auction By Type test 4: Log in");
		System.out.println("5: Get List Auction By Type test 5: Outdate token");
		System.out.println("6: Get List Auction By Type test 6: Type: đã bán");
		System.out.println("7: Get List Auction By Type test 7: TypeID is not exist");
		luachonTest = sc.nextInt();
		sc.nextLine();
		GetListAuctionByType test = new GetListAuctionByType();
		if(luachonTest==0) {
		test.test1();
		test.test2();
		test.test3();
		test.test4();
		test.test5();
		test.test6();
		test.test7();
		}
		else if(luachonTest==1) {
			test.test1();
			}
		else if(luachonTest==2) {
			test.test2();
			}
		else if(luachonTest==3) {
			test.test3();
			}
		else if(luachonTest==4) {
			test.test4();
			}
		else if(luachonTest==5) {
			test.test5();
			}
		else if(luachonTest==6) {
			test.test6();
			}
		else if(luachonTest==7) {
			test.test7();
			}
	}
		else if(luachonAPI==9) {
			System.out.println("9: Get Detail Auction");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: Get Detail Auction test 1: Dang dien ra ");
			System.out.println("2: Get Detail Auction test 2: Sap dien ra");
			System.out.println("3: Get Detail Auction test 3: Da ket thuc");
			luachonTest = sc.nextInt();
			sc.nextLine();
			GetDetailAuction da = new GetDetailAuction();
			if(luachonTest==0) {
				da.DA1();
				da.DA2();
				da.DA3();
			}
			else if(luachonTest==1) {
				da.DA1();
			}
			else if(luachonTest==2) {
				da.DA2();
			}
			else if(luachonTest==3) {
				da.DA3();
			}
		}
		else if(luachonAPI==10) {
			System.out.println("5: Create Auctions");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: List auctions test 1: create success ");
			System.out.println("2: List auctions test 2: title exist");
			System.out.println("3: List auctions test 3: category_id null");
			System.out.println("4: List auctions test 4: start date null");
			System.out.println("5: List auctions test 5: start date befor present time");
			System.out.println("6: List auctions test 6: end date null");
			System.out.println("7: List auctions test 7: end date earlier than start date");
			System.out.println("8: List auctions test 8: title null");
			System.out.println("9: List auctions test 9: start date incorrect format");
			System.out.println("10: List auctions test 10: end date incorrect format");
			luachonTest = sc.nextInt();
			sc.nextLine();
			CreateAuctionsTest test = new CreateAuctionsTest();
			if(luachonTest==0) {
			test.Test1();
			test.Test2();
			test.Test3();
			test.Test4();
			test.Test5();
			test.Test6();
			test.Test7();
			test.Test8();
			test.Test9();
			test.Test10();
			}
			else if(luachonTest==1) {
				test.Test1();
				}
			else if(luachonTest==2) {
				test.Test2();
				}
			else if(luachonTest==3) {
				test.Test3();
				}
			else if(luachonTest==4) {
				test.Test4();
				}
			else if(luachonTest==5) {
				test.Test5();
				}
			else if(luachonTest==6) {
				test.Test6();
				}
			else if(luachonTest==7) {
				test.Test7();
				}
			else if(luachonTest==8) {
				test.Test8();
				}
			else if(luachonTest==9) {
				test.Test9();
				}
			else if(luachonTest==10) {
				test.Test10();
				}
			
		}
		else if(luachonAPI==11) {
			System.out.println("11: Edit Auction ");
			
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: Edit Auction test 1: Auction đã duyệt ");
			System.out.println("2: Edit Auction test 2: Auction đã duyệt, Đăng xuất");
			System.out.println("3: Edit Auction test 3: Edit Category id");
			System.out.println("4: Edit Auction test 4: Edit all fields");
			System.out.println("5: Edit Auction test 5: Edit trùng title ");

			luachonTest = sc.nextInt();
			sc.nextLine();
			EditAuction editAuc = new EditAuction();
			if(luachonTest==0) {
				editAuc.EditAuction1();
				editAuc.EditAuction2();
				editAuc.EditAuction3();
				editAuc.EditAuction4();
				editAuc.EditAuction5();
				editAuc.EditAuction6();
			}
			else if(luachonTest==1) {
				editAuc.EditAuction1();
				}
			else if(luachonTest==2) {
				editAuc.EditAuction2();
				}
			else if(luachonTest==3) {
				editAuc.EditAuction3();
				}
			else if(luachonTest==4) {
				editAuc.EditAuction4();
				}
			else if(luachonTest==5) {
				editAuc.EditAuction5();
				}
			else if(luachonTest==6) {
				editAuc.EditAuction6();
				}
			
		}
		else if(luachonAPI==12) {	
			System.out.println("12: Create Item ");
			
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: CreatItem test 1: Trùng thông tin ");
			System.out.println("2: CreatItem test 2: name null ");
			System.out.println("3: CreatItem test 3: Starting price null ");
			System.out.println("4: CreatItem test 4: Starting price is not a number ");
			System.out.println("5: CreatItem test 5:Brand id null ");
			System.out.println("6: CreatItem test 6:Description id null ");
			System.out.println("7: CreatItem test 7:Trùng series ");
			System.out.println("8: CreatItem test 8:Series hơn 10 kí tự ");

			luachonTest = sc.nextInt();
			sc.nextLine();
			CreatItem crtIt = new CreatItem();
			if(luachonTest==0) {
				crtIt.CreatItem1();
				crtIt.CreatItem2();
				crtIt.CreatItem3();
				crtIt.CreatItem4();
				crtIt.CreatItem5();
				crtIt.CreatItem6();
				crtIt.CreatItem7();
				crtIt.CreatItem8();
				
			}
			else if(luachonTest==1) {
				crtIt.CreatItem1();
				}
			else if(luachonTest==2) {
				crtIt.CreatItem2();
				}
			else if(luachonTest==3) {
				crtIt.CreatItem3();
				}
			else if(luachonTest==4) {
				crtIt.CreatItem4();
				}
			else if(luachonTest==5) {
				crtIt.CreatItem5();
				}
			else if(luachonTest==6) {
				crtIt.CreatItem6();
				}
			else if(luachonTest==7) {
				crtIt.CreatItem7();
				}
			else if(luachonTest==8) {
				crtIt.CreatItem8();
				}
			
			
	
			
		}
			else if(luachonAPI==13) {
			System.out.println("13: Create comment");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: Create comment test 1: Correct data ");
			System.out.println("2: Create comment test 2: content null");
			System.out.println("3: Create comment test 3: comment_last_id null");
			System.out.println("4: Create comment test 4: Auction đang chờ duyệt");
			System.out.println("5: Create comment test 5: Auction đã kết thúc nhưng vẫn comment được");
			System.out.println("6: Create comment test 6: comment_last_id không tồn tại");
			System.out.println("7: Create comment test 7: Chưa đăng nhập");
			luachonTest = sc.nextInt();
			sc.nextLine();
			CreateComment test = new CreateComment();
			if(luachonTest==0) {
			test.test1();
			test.test2();
			test.test3();
			test.test4();
			test.test5();
			test.test6();
			test.test7();
			}
			else if(luachonTest==1) {
				test.test1();
				}
			else if(luachonTest==2) {
				test.test2();
				}
			else if(luachonTest==3) {
				test.test3();
				}
			else if(luachonTest==4) {
				test.test4();
				}
			else if(luachonTest==5) {
				test.test5();
				}
			else if(luachonTest==6) {
				test.test6();
				}
			else if(luachonTest==7) {
				test.test7();
				}
		}
		
		else if(luachonAPI==14) {
			System.out.println("14: Get List Comment");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: Get list coments test 1: correct data ");
			System.out.println("2: Get list coments test 2: index null");
			System.out.println("3: Get list coments test 3: count null");
			luachonTest = sc.nextInt();
			sc.nextLine();
			GetListComments lc = new GetListComments();
			if(luachonTest==0) {
			lc.LC1();
			lc.LC2();
			lc.LC3();
			}
			else if(luachonTest==1) {
				lc.LC1();
				}
			else if(luachonTest==2) {
				lc.LC2();
				}
			else if(luachonTest==3) {
				lc.LC3();
				}
			
			
		}
		else if(luachonAPI==15) {
			System.out.println("15: Create Bid");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: Create bid test 1: price lower than present price ");
			System.out.println("2: Create bid test 2: price null");
			System.out.println("3: Create bid test 3: auction out date");
			System.out.println("4: Create bid test 4: auction out date");
			System.out.println("5: Create bid test 5: create bid success");
			luachonTest = sc.nextInt();
			sc.nextLine();
			CreateBidsTest test = new CreateBidsTest();
			if(luachonTest==0) {
			test.Test1();
			test.Test2();
			test.Test3();
			test.Test4();
			test.Test5();
			}
			else if(luachonTest==1) {
				test.Test1();
				}
			else if(luachonTest==2) {
				test.Test2();
				}
			else if(luachonTest==3) {
				test.Test3();
				}
			else if(luachonTest==4) {
				test.Test4();
				}
			else if(luachonTest==5) {
				test.Test5();
				}
			
		}
		else if(luachonAPI==16) {
			System.out.println("16: Get List Bids");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: Get list bids test 1: Correct data");
			System.out.println("2: Get list bids test 2: Index null");
			System.out.println("3: Get list bids test 3: Count null");
			System.out.println("4: Get list bids test 4: Auction chưa duyệt");

			GetListBids getListBids = new GetListBids();
			

			luachonTest = sc.nextInt();
			sc.nextLine();
			
			if(luachonTest==0) {
				getListBids.ListBids1();
				getListBids.ListBids2();
				getListBids.ListBids3(); 
				getListBids.ListBids4();
			}
			else if(luachonTest==1) {
				getListBids.ListBids1();
				}
			else if(luachonTest==2) {
				getListBids.ListBids2();
				}
			else if(luachonTest==3) {
				getListBids.ListBids3(); 
				}
			else if(luachonTest==4) {
				getListBids.ListBids4();
				}
			
		}
		else if(luachonAPI==17) {
			System.out.println("17: Get List CateGoires");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: List auctions test 1: create success ");
			GetListCategoires glc = new GetListCategoires();
			luachonTest = sc.nextInt();
			sc.nextLine();
				if(luachonTest==0) {
				glc.GetListCategoires1();
			}
				if(luachonTest==1) {
				glc.GetListCategoires1();
			}
		}
		else if(luachonAPI==18) {
			System.out.println("18: Get List Brands");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("1: Get list brands test 1: The code should be 1000 and message is OK ");
			luachonTest = sc.nextInt();
			sc.nextLine();
			GetListBrands test = new GetListBrands();
			if(luachonTest==1) {
				test.test1();
			}
		}
		else if(luachonAPI==19) {
			System.out.println("19: Accept Max Bid");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: Accept Max Bid test 1: chua dang nhap ");
			System.out.println("2: Accept Max Bid test 2: khong co quyen");
			System.out.println("3: Accept Max Bid test 3: phien dau gia chua ket thuc");
			System.out.println("3: Accept Max Bid test 4: da ban");
			System.out.println("3: Accept Max Bid test 5: chua co tra gia nao");
			luachonTest = sc.nextInt();
			sc.nextLine();
			AcceptMaxBid amb = new AcceptMaxBid();
			if(luachonTest==0) {
				amb.AMB1();
				amb.AMB2();
				amb.AMB3();
				amb.AMB4();
				amb.AMB5();
			}
			else if(luachonTest==1) {
				amb.AMB1();
			}
			else if(luachonTest==2) {
				amb.AMB2();
			}
			else if(luachonTest==3) {
				amb.AMB3();
			}
			else if(luachonTest==4) {
				amb.AMB4();
			}
			else if(luachonTest==5) {
				amb.AMB5();
			}
		}
		else if(luachonAPI==20) {
			System.out.println("20: Contact Us");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: Contact us test 1: success ");
			System.out.println("2: Contact us test 2: name null");
			System.out.println("3: Contact us test 3: phone null");
			System.out.println("4: Contact us test 4: email null");
			System.out.println("5: Contact us test 5: content null");
			System.out.println("6: Contact us test 6: report_type null");
			System.out.println("7: Contact us test 7: report_type invalid");
			System.out.println("8: Contact us test 8: phone more than 60 characters");
			System.out.println("9: Contact us test 9: name more than 255 characters");
			System.out.println("10: Contact us test 10: email more than 255 characters");
			System.out.println("11: Contact us test 11: email incorrect format");
			luachonTest = sc.nextInt();
			sc.nextLine();
			ContactUsTest test = new ContactUsTest();
			if(luachonTest==0) {
			test.Test1();
			test.Test2();
			test.Test3();
			test.Test4();
			test.Test5();
			test.Test6();
			test.Test7();
			test.Test8();
			test.Test9();
			test.Test10();
			test.Test11();
			
			}
			else if(luachonTest==1) {
				test.Test1();
				}
			else if(luachonTest==2) {
				test.Test2();
				}
			else if(luachonTest==3) {
				test.Test3();
				}
			else if(luachonTest==4) {
				test.Test4();
				}
			else if(luachonTest==5) {
				test.Test5();
				}
			else if(luachonTest==6) {
				test.Test6();
				}
			else if(luachonTest==7) {
				test.Test7();
				}
			else if(luachonTest==8) {
				test.Test8();
				}
			else if(luachonTest==9) {
				test.Test9();
				}
			else if(luachonTest==10) {
				test.Test10();
				}
			else if(luachonTest==11) {
				test.Test11();
				}
			
		}
		else if(luachonAPI==21) {
			System.out.println("21: Like Auction");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: Like auctions test 1: Correct data");
			System.out.println("2: Like auctions test 2: Auction chưa duyệt");
			System.out.println("3: Like auctions test 3: Không đăng nhập");


			LikeAuction likeAuc = new LikeAuction();
			

			luachonTest = sc.nextInt();
			sc.nextLine();
			
			if(luachonTest==0) {
				likeAuc.likeAuction1();
				likeAuc.likeAuction2();
				likeAuc.likeAuction3();
				likeAuc.likeAuction4();
				
			}
			else if(luachonTest==1) {
				likeAuc.likeAuction1();
				}
			else if(luachonTest==2) {
				likeAuc.likeAuction2();
				}
			else if(luachonTest==3) {
				likeAuc.likeAuction3();
				}
			else if(luachonTest==4) {
				likeAuc.likeAuction4();
				}

			
			
		}
		else if(luachonAPI==22) {	
			System.out.println("22: Get List Likes");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: Get List Likes test 1: Correct data");
			System.out.println("2: Get List Likes test 2: Logout");
			System.out.println("3: Get List Likes test 3: not logged in");
			GetListLikes gll = new GetListLikes();
			luachonTest = sc.nextInt();
			sc.nextLine();
			
			if(luachonTest==0) {
				gll.GetListLikes1();
				gll.GetListLikes2();
				gll.GetListLikes3();	
			}
			else if(luachonTest==1) {
				gll.GetListLikes1();
				}
			else if(luachonTest==2) {
				gll.GetListLikes2();
				}
			else if(luachonTest==3) {
				gll.GetListLikes3();
				}
		}
		
		else if(luachonAPI==23) {
			System.out.println("23: Total Likes Of Auction");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("1: Total likes of auction test 1: The code should be 1000 and message is OK ");
				luachonTest = sc.nextInt();
				sc.nextLine();
			TotalLikesOfAuction test = new TotalLikesOfAuction();
			if(luachonTest==1) {
					test.test1();
				}
		}
		else if(luachonAPI==24) {
			System.out.println("24: Get News");
			System.out.println("24: Get News");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: Get News test 1: correct data ");
			System.out.println("2: Get News test 2: index null");
			System.out.println("3: Get News test 3: count null");
			luachonTest = sc.nextInt();
			sc.nextLine();
			GetNews getNews = new GetNews();
			if(luachonTest==0) {
				getNews.GetNews1();
				getNews.GetNews2();
				getNews.GetNews3();
				getNews.GetNews4();
			}
			else if(luachonTest==1) {
				getNews.GetNews1();
			}
			else if(luachonTest==2) {
				getNews.GetNews2();
			}
			else if(luachonTest==3) {
				getNews.GetNews3();
			}
		}
		else if(luachonAPI==25) {
			System.out.println("25: Read New");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: Read new test 1: success");
			System.out.println("2: Read new test 2: not login");
			luachonTest = sc.nextInt();
			sc.nextLine();
			readnewTest test = new readnewTest();
			if(luachonTest==0) {
			test.Test1();
			test.Test2();
			}
			else if(luachonTest==1) {
				test.Test1();
				}
			else if(luachonTest==2) {
				test.Test2();
				}

		}
		else if(luachonAPI==26) {
			System.out.println("26: Get Notifications");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: Get Notifications 1: Not login");
			System.out.println("2: Get Notifications 2: Correct data");
			System.out.println("3: Get Notifications 3: Logout");


			GetNotifications getNotifi = new GetNotifications();
			

			luachonTest = sc.nextInt();
			sc.nextLine();
			
			if(luachonTest==0) {
				getNotifi.getNoti1();
				getNotifi.getNoti2(); 
				getNotifi.getNoti3();
			}
			else if(luachonTest==1) {
				getNotifi.getNoti1();
				}
			else if(luachonTest==2) {
				getNotifi.getNoti2();
				}
			else if(luachonTest==3) {
				getNotifi.getNoti3();
				}
			
			
		}
		else if(luachonAPI==27) {
			System.out.println("27: Read Notifications");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: Read Notifications 1: Correct data");
			System.out.println("2: Read Notifications 2: not logged in");
			
			ReadNotifications rn = new ReadNotifications();
			luachonTest = sc.nextInt();
			sc.nextLine();
			if(luachonTest==0) {
				rn.ReadNotifications1();
				rn.ReadNotifications2(); 
			}
			else if(luachonTest==1) {
				rn.ReadNotifications1();
				}
			else if(luachonTest==2) {
				rn.ReadNotifications2(); 
				}		
		}
		
		else if(luachonAPI==28) {
			System.out.println("28: Get Slider");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("1: Get slider test 1: The code should be 1000 and message is OK ");
			System.out.println("2: Get slider test 2: chưa đăng nhập ");
			
					luachonTest = sc.nextInt();
					sc.nextLine();
				GetSlider test = new GetSlider();
			if(luachonTest==1) {
						test.test1();
			}
			if(luachonTest==2) {
						test.test2();
			}
		}
		
		else if(luachonAPI==29) {
			System.out.println("29: Search");
			System.out.println("----------Mời chọn Test Case :----------");
			System.out.println("0: All unit test ");
			System.out.println("1: Search test 1: correct data");
			System.out.println("2: Search test 2: type null");
			System.out.println("3: Search test 3: key null");
			System.out.println("4: Search test 4: tim kiem theo gia khoi diem");
			System.out.println("5: Search test 5: tim kiem theo thoi gian bat dau cua phien dau gia");
			System.out.println("6: Search test 6: tim kiem theo thoi gian ket thuc cua phien dau gia");
			System.out.println("7: Search test 7: tim kiem theo ten cua phien dau gia");
			System.out.println("8: Search test 8: khong tim thay ket qua");
			luachonTest = sc.nextInt();
			sc.nextLine();
			Search search = new Search();
			if(luachonTest==0) {
				search.Search1();
				search.Search2();
				search.Search3();
				search.Search4();
				search.Search5();
				search.Search6();
				search.Search7();
				search.Search8();
			}
			else if(luachonTest==1) {
				search.Search1();
			}
			else if(luachonTest==2) {
				search.Search2();
			}
			else if(luachonTest==3) {
				search.Search3();
			}
			else if(luachonTest==4) {
				search.Search4();
			}
			else if(luachonTest==5) {
				search.Search5();
			}
			else if(luachonTest==6) {
				search.Search6();
			}
			else if(luachonTest==7) {
				search.Search7();
			}
			else if(luachonTest==8) {
				search.Search8();
			}

		}
		
		else if(luachonAPI==30) {
			System.out.println("30: Delete Comment");
			System.out.println("Delete comment test: can't delete other people's comment");
			DeletecommentTest test = new DeletecommentTest();
			test.Test();
		}
		else  {
			System.out.println("Lựa chọn lỗi");			
		}
	}
}

