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
import com.nds.bean.Subscription;
import com.nds.dao.SubscriptionDao;
import com.nds.dbutil.ConnectionManager;

//import DataBase.DatabaseConnection;

public class SubscriptionDaoImpl implements SubscriptionDao {
	public Subscription findById(int sub_id) {
		Subscription subscription=null;
		Connection conn = ConnectionManager.getConnection();
		String strSQL = "select * from  Subscription where subs_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(strSQL);
			pstmt.setInt(1, sub_id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				subscription = new Subscription();
				subscription.setCus_id(rs.getInt("Customer_id"));
				subscription.setSub_id(rs.getInt("subs_id"));
				subscription.setPub_id(rs.getInt("pub_id"));
				subscription.setdesc(rs.getString("descriptions"));
				
			}
			pstmt.close();
			rs.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}

		return subscription;
	}
	public int AddSubscription(Subscription su) {
		Connection conn = ConnectionManager.getConnection();
		int count = 0;
		String strSQL = "insert into Subscription(subs_id, Customer_id, pub_id, descriptions) " + "values(?,?,?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(strSQL);
			ps.setString(1, su.getSub_id() + "");
			ps.setString(2, su.getCus_id() + "");
			ps.setString(3, su.getPub_id() + "");
			ps.setString(4, su.getdesc() + "");
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

	public void ViewCustomer() {

	}

	public int DeleteSubscription(int id) {
		Connection conn = ConnectionManager.getConnection();
		int count = 0;
		String srtSQL = "delete from Subscription where subs_id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(srtSQL);
			pstmt.setInt(1, id);
			count = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
		return count;
	}

	public int UpdateSubscription(Subscription su) {
		Connection conn = ConnectionManager.getConnection();
		int count = 0;
		String strSQL = "update Subscription set Customer_id=?, pub_id=?,descriptions=? " + " where subs_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(strSQL);

			ps.setInt(1, su.getCus_id());
			ps.setInt(2, su.getPub_id());
			ps.setInt(4, su.getSub_id());
			ps.setString(3, su.getdesc());
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

	public List<Subscription> findAll() {

		List<Subscription> subscribe= new ArrayList<>();
		Connection conn = ConnectionManager.getConnection();
		String strSQL = "select * from Subscription";
		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(strSQL);
			while (rs.next()) {
//				subscribe.add(new Subscription(rs.getInt("subs_id"),rs.getInt("Customer_id"),Integer.parseInt(rs.getString("pub_id")),String.valueOf(rs.getInt("desc"))));
			Subscription subscription = new Subscription();
			subscription.setCus_id(rs.getInt("Customer_id"));
			subscription.setSub_id(rs.getInt("subs_id"));
			subscription.setPub_id(rs.getInt("pub_id"));
			subscription.setdesc(rs.getString("descriptions"));
			subscribe.add(subscription);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}

		return subscribe;
	}

}