package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		SaleManager sale = new SaleManager(SaleDao.getInstance());
		MemberManager manager = new MemberManager(MemberDao.getInstance());
		Scanner sc = new Scanner(System.in);
		
		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("로그인 화면");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			int num = Integer.parseInt(sc.nextLine().trim());
			switch (num) {
			case 1:
				manager.memAdd();
				manager.chkLogin();
				break;
			case 2:			
				manager.chkLogin();
				break;
			default :
				System.out.println("잘못 눌렀습니다.");
			}
			
			while (true) {
			System.out.println("1. 주문하기");
			System.out.println("2. 포인트확인");
			System.out.println("3. 내 정보 확인");
			num = Integer.parseInt(sc.nextLine().trim());
			
			switch (num) {
			case 1:
				sale.order();
				sale.saleList();
				break;
			case 2:
				break;
			case 3:
				manager.myInfo();
				System.out.println("1. 정보수정");
				System.out.println("2. 회원탈퇴");
				num = Integer.parseInt(sc.nextLine().trim());
				switch (num) {
				case 1:
					manager.memEdit();
					break;
				case 2:
					manager.memDel();
					return;				
				}
			}
		 }	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}