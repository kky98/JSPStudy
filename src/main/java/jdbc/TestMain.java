package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestMain {
	public static void main(String[] args) {
			ConnectionFactory db = ConnectionFactory.getInstance();
			PreparedStatement ps = null;
			ResultSet rs = null;
			Connection conn = null;
			try {
				conn = db.getConnection();
				System.out.println(conn);
				StringBuffer query = new StringBuffer();
				query.append(" SELECT user_id");
				query.append("      , user_pw");
				query.append("      , user_nm");
				query.append("      , user_mail");
				query.append("      , user_mileage");
				query.append(" FROM tb_user");
				ps = conn.prepareStatement(query.toString());
				rs = ps.executeQuery(); // 쿼리문실행
				while(rs.next()) {
					  String userId = rs.getString("user_id");
					  String userNm = rs.getString("user_nm");
					  int userMileage = rs.getInt("user_mileage");
				      System.out.println("아이디:"+userId +",이름:" + userNm 
				    		             + ",마일리지:" + userMileage);	
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				// connection객체를 꼭 닫아야함.
				// 안닫으면 계속 쌓여서 에러 발생
				if(rs != null) {try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
				if(ps != null) {try {ps.close();} catch (SQLException e) {e.printStackTrace();}}
				if(conn != null) {try {conn.close();} catch (SQLException e) {e.printStackTrace();}}
			}
	}
}
