package com.nds.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.nds.bean.Customer;
import com.nds.bean.Delivery;
import com.nds.dbutil.ConnectionManager;

//import DataBase.DatabaseConnection;

public class CustomerDaoImpl {
	
	
	public int AddCustomer (Customer cd) {
		Connection conn = ConnectionManager.getConnection();
		int count = 0;
		String strSQL= "insert into Customer(Customer_id,firstName,LastName,address,contactno) "
				+ "values(?,?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(strSQL);
			ps.setInt(1, cd.getCusid());
			ps.setString(1, cd.getFirstName());
			ps.setString(2, cd.getLastName());
			ps.setString(3, cd.getAddress());
			ps.setString(4, cd.getContactno());
			count = ps.executeUpdate();
			ps.close();
			}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				ConnectionManager.closeConnection(conn);
			}
			return count;
	}
	
	public List<Customer> ViewCustomer () {
		List<Customer> customerlist = new ArrayList<>();
		Connection conn = ConnectionManager.getConnection();
		String strSQL = "select * from Customer";
		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(strSQL);
			while (rs.next())  {
				Customer customer = new Customer(0, strSQL, strSQL, strSQL, strSQL);
			
				customer.setFirstName(rs.getString("firstName"));
				customer.setLastName(rs.getString("lastName"));
				customer.setCusid(rs.getInt("Customer_id"));
				customer.setAddress(rs.getString("address"));
				customer.setContactno(rs.getString("cusContactNo"));
				customerlist.add(customer);
			}
			stmt.close();
			rs.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}

		return customerlist;
		
	}
	
	public int DeleteCustomer (int id) {
		Connection conn = ConnectionManager.getConnection();
		int count = 0;
		String srtSQL = "delete from Customer where Customer_id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(srtSQL);
			pstmt.setInt(1, id);
			count = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			ConnectionManager.closeConnection(conn);
		}
		return count;
		}
	
	public int ModifyCustomer (Customer cd) {
		Connection conn = ConnectionManager.getConnection();
		int count = 0;
		String strSQL = "update Customer set firstName=?, lastName=?, address=?, contactno=? " + " where Customer_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(strSQL);
			ps.setString(1, cd.getFirstName());
			ps.setString(2, cd.getLastName());
			ps.setString(3, cd.getAddress());
			ps.setString(4, cd.getContactno());
			count = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
		return count;
		
	}
}
