package bbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class bbsDAO {
	private Connection conn;
	private ResultSet rs;
	
	public bbsDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/KISBBS";
			String dbID = "root";
			String dbPassword = "escclubproject";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getDate() {
		String SQL = "SELECT NOW()";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getString(1);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return "";
	}
	
	public int getNext() {
		String SQL = "SELECT ID FROM FROM BBS ORDER BY ID DESC";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
	
	public int write(String title, String userID, int anonymous, String time, String content) {
		String SQL = "INSERT INTO BBS VALUE(DEFAULT, ?, ?, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, title);
			ps.setString(2, userID);
			ps.setInt(3, anonymous);
			ps.setString(4, time);
			ps.setString(5, content);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1) + 1;
			}
			return 1;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
}
