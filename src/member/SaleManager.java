package member;

import java.io.DataOutput;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class SaleManager {



	SaleDao dao;
	Scanner scanner;


	SaleManager(SaleDao dao){
		this.dao = dao;
		scanner= new Scanner(System.in);
	}

	// DB에 있는 sale table을 가져오도록 한다. 
	// 행단위로 sale 객체로 만들어서 전체를 arrayList로 만든다. 
	// 관리자가 이 table을 조회할 수 있도록 한다. 



	// 판매자가 리스틑 확인한다.
	void saleList() {
		// Connection 객체 생성 
		Connection conn = null;

		// 연결
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";

		try {
			conn= DriverManager.getConnection(jdbcUrl, user, pw);

			List<Sale> list = dao.getSaleList(conn);

			System.out.println("판매 정보 리스트");
			System.out.println("-------------------------------------");
			System.out.println("판매코드 \t 상품명  \t 가격  \t 판매 날짜");
			System.out.println("-------------------------------------");

			for(Sale sale : list) {
				System.out.printf("%d \t %s \t %d \t %s \n", 
						sale.getSalecode(), sale.getSname(), sale.getPrice(), sale.getSaledate()
						);
			}
			System.out.println("-------------------------------------");


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}


	void order() {
		// 주문하기 = sale DB에 저장한다. 
		
		//connection객체 생성
		
		int americano = 4100;
		int latte = 4600;
		int sandwich =6200;
		int salad = 5000;
		int cake= 5500;
		
		
		
		Connection conn = null;

		// 연결
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";
		
		try {
			conn = DriverManager.getConnection(jdbcUrl,user,pw);
			
			System.out.println("주문하기");

			System.out.println("메뉴 입니다.");
			System.out.println("------------------------------------");
			System.out.println("1. Amerciano : 4100");
			System.out.println("2. Latte : 4600");
			System.out.println("3. Sandwich : 6200");
			System.out.println("4. salad : 5000");
			System.out.println("5. cake : 5500");
			System.out.println("6. 주문 완료");
			System.out.println("------------------------------------");

			//while(true)
			System.out.println("원하시는 메뉴의 번호와 수량을 입력하세요.");
			System.out.println("예시)1 3");
			String inputData = scanner.nextLine();
			String[] inputDatas = inputData.split(" ");

			//샀을 때 sale객체로 정보 넣기
			
			ArrayList<Sale> list = new ArrayList<>();
			switch(inputDatas[0]) {

			case "1":
				list.add(new Sale("americano", Integer.parseInt(inputDatas[1])*americano));
				System.out.println("americano"+ inputDatas[1]+"잔 주문");
				break;
			case "2":
				list.add(new Sale("latte", Integer.parseInt(inputDatas[1])*latte));
				System.out.println("latte"+ inputDatas[1]+"잔 주문");
				break;
			case "3":
				list.add(new Sale("sandwich", Integer.parseInt(inputDatas[1])*sandwich));
				System.out.println("sandwich"+ inputDatas[1]+"개 주문");
				break;
			case "4":
				list.add(new Sale("salad", Integer.parseInt(inputDatas[1])*salad));
				System.out.println("salad"+ inputDatas[1]+"개 주문");
				break;
			case "5": 
				list.add(new Sale("cake", Integer.parseInt(inputDatas[1])*cake));
				System.out.println("cake"+ inputDatas[1]+"개 주문");
				break;
			case "6":
				System.exit(0);
			}
			
			
			int result = dao.insertSale(conn, list);
			
			if(result> 0) {
				System.out.println("입력완료");
			}else {
				System.out.println("입력 실패");
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}