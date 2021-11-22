package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public UserDAO() {
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
	
	public int login(String userID, String userPassword) {
		String SQL = "SELECT userPassword FROM USER WHERE userID = ?";
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1,  userID);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				if (rs.getString(1).equals(userPassword)) {
					return 1;
				}
				else {
					return 0;
				}
			}
			return -1;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return -2;
	}
	
	public int join(User user) {
		String SQL = "INSERT INTO USER VALUES (?, ?, ?, ?, DEFAULT, DEFAULT, ?, ?, ?, ? ,?, DEFAULT)";
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1,  user.getUserID());
			ps.setString(2,  user.getUserPassword());
			ps.setInt(3,  user.getGrade());
			ps.setString(4,  user.getEmail());
			ps.setString(5,  user.getInterestOne());
			ps.setString(6,  user.getInterestTwo());
			ps.setString(7,  user.getInterestThree());
			ps.setString(8,  user.getFirstName());
			ps.setString(9,  user.getLastName());
			return ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			
		}
		return -1;
	}
}
