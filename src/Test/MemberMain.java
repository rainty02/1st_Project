package Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import Menu.MenuDao;
import Menu.MenuManager;

public class MemberMain {

	public static void main(String[] args) {

		
		MemberManager manager = new MemberManager(MemberDao.getInstance());
		MenuManager menuManager = new MenuManager(MenuDao.getInstance());
		Login login = new Login(MemberDao.getInstance());
		Point point = new Point();
		Scanner sc = new Scanner(System.in);
		
		try {
			// 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");

			System.out.println("로그인 화면");
			System.out.println("1. 회원가입");
			System.out.println("2. 로그인");
			System.out.print("메뉴를 선택하세요 > ");
			String num = sc.nextLine().trim();
			switch (num) {
			case "1":
				manager.memAdd();
				login.chkLogin();
				break;
			case "2":			
				login.chkLogin();
				break;
			case "admin":
				System.out.println("관리자 모드");
				System.out.println("1. 회원정보");
				System.out.println("2. 판매정보");
				System.out.println("3. 메뉴정보");
				System.out.print("메뉴를 선택하세요 > ");
				int num2 = Integer.parseInt(sc.nextLine());
				
				switch(num2) {
				case 1:
					manager.memList();
					break;
				case 2:
					break;
				case 3:
					while(true) {
					System.out.println("1. 메뉴 전체리스트");
					System.out.println("2. 메뉴 데이터 추가");
					System.out.println("3. 메뉴 데이터 수정");
					System.out.println("4. 메뉴 삭제");
					System.out.println("5. 프로그램 종료");
					System.out.print("메뉴를 선택하세요 > ");
					num2 = Integer.parseInt(sc.nextLine());
					
					switch(num2) {
					case 1:
						menuManager.menuList();
						break;
					case 2:
						menuManager.menuAdd();
						break;
					case 3:
						menuManager.menuEdit();
						break;
					case 4:
						menuManager.menuDel();
						break;	
					case 5:
						System.out.println("프로그램을 종료합니다.");
						return;
					}
					}
				
			default :
				System.out.println("잘못 눌렀습니다.");
			}
			}
			while (true) {
			System.out.println(login.currentId +"님 환영합니다.");
			System.out.println("현재 적립 포인트 " + point.readPoint(login.currentId) + "점");
			System.out.println("1. 주문하기");
			System.out.println("2. 내 정보 확인");
			int num3 = Integer.parseInt(sc.nextLine().trim());
			
			switch (num3) {
			case 1:
				break;
			case 2:
				manager.myInfo(login.currentId);
				System.out.println("1. 정보수정");
				System.out.println("2. 회원탈퇴");
				num3 = Integer.parseInt(sc.nextLine().trim());
				switch (num3) {
				case 1:
					manager.memEdit(login.currentId);
					break;
				case 2:
					manager.memDel(login.currentId);
					return;				
				}
			}
		 }	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}