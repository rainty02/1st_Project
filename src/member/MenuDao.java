package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MenuDao {

	private MenuDao() {}
	static private MenuDao dao = new MenuDao();
	public static MenuDao getInstance() {
		return dao;
	}
	
	// 메뉴 데이터 전체 출력
	ArrayList<Menu> getList(Connection con) {
		
		ArrayList<Menu> list = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		
		
		try {
			String sql = "select * from menu";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			while(rs.next()) {
				Menu menu = new Menu(rs.getString(2), rs.getInt(3));
				list.add(menu);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return list;		
	}
	
	// 2. 메뉴 데이터 입력
	int insertMenu(Connection con, Menu menu) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "insert into memu(menucode, mname, price) values (menu_sq.nextval, ?, ?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, menu.getMname());
			pstmt.setInt(2, menu.getPrice());
			
			result = pstmt.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	// 3. 메뉴 데이터 수정
	int editMenu(Connection con, Menu menu, String mname) {
		int result = 0;		
		PreparedStatement pstmt = null;
		
		String sql = "update menu set mname = ?, price =? where mname = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, menu.getMname());
			pstmt.setInt(2, menu.getPrice());
			pstmt.setString(3, mname);
		
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	// 4. 메뉴 데이터 삭제
	int deleteMenu(Connection con, String mname) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {	
			String sql = "delete from menu where mname = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mname);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}	
}