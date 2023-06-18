package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
	private static final String CONN_URL = "jdbc:mysql://localhost:3306/cake_db?useUnicode=true&characterEncoding=utf-8";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//用户的登录功能
    public User findByUsernameAndPassword(String username, String password) {
    	Connection conn = null;
    	PreparedStatement statement = null;
    	ResultSet rs = null;
    	try {
			conn = DriverManager.getConnection(CONN_URL, "root", "");
			statement = conn.prepareStatement(
					"select * from tbl_user where username = ? and password = ?;");
			statement.setString(1, username);
			statement.setString(2, password);
			rs = statement.executeQuery();
			if (rs.next()) {
				return new User(
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("realname"),
						rs.getInt("state"),
						rs.getInt("failcount")
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    	return null;
    }
    
    public User findByUsername(String username) {
    	Connection conn = null;
    	PreparedStatement statement = null;
    	ResultSet rs = null;
    	try {
    		conn = DriverManager.getConnection(CONN_URL, "root", "");
    		statement = conn.prepareStatement(
    				"select * from tbl_user where username = ?;");
    		statement.setString(1, username);
    		rs = statement.executeQuery();
    		if (rs.next()) {
    			return new User(
    					rs.getString("username"),
    					rs.getString("password"),
    					rs.getString("realname"),
    					rs.getInt("state"),
    					rs.getInt("failcount")
    					);
    		}
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} finally {
    		try {
    			if (rs != null) {
    				rs.close();
    			}
    			if (statement != null) {
    				statement.close();
    			}
    			if (conn != null) {
    				conn.close();
    			}
    		} catch (SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	return null;
    }

    //修改用户状态的功能
    public void updateState(String username, int failCount) {
    	Connection conn = null;
    	PreparedStatement statement = null;
    	ResultSet rs = null;
    	try {
    		conn = DriverManager.getConnection(CONN_URL, "root", "");
			statement = conn.prepareStatement(
					"update tbl_user set failcount = ? where username = ?");
			statement.setInt(1, failCount);
			statement.setString(2, username);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
}
