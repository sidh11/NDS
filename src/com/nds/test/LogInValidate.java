package com.nds.test;
import java.sql.Connection; 
import java.sql.ResultSet; 
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.nds.dbutil.ConnectionManager; 

public class LogInValidate{
	public boolean validate(String username, String password) {
		return (username.equals("") && password.equals("")) ? false : true;
	}

	public boolean ValidateV(String username, String password) {
		return ((username.length() >= 5 && username.length() <= 10)
				&& (password.length() >= 5 && password.length() <= 10)) ? true : false;
	}

	public boolean FetchData(String UserName, String paswd) {

		Connection con = ConnectionManager.getConnection();
		try {
			PreparedStatement prd = (PreparedStatement) con
					.prepareStatement("select * from Login where UserName=? and paswd=?");
			prd.setString(1, UserName);
			prd.setString(2, paswd);
			ResultSet rs1 = prd.executeQuery();
			if (!rs1.next() ) {
				return false;
			}else {
				return true;
			}
			
		} catch (SQLException ex) {
		
			ex.printStackTrace();
		}
		return false;
	}

}
