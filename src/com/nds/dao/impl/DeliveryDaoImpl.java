package com.nds.dao.impl;

import com.nds.bean.Delivery;
import com.nds.dao.DeliveryDao;
import com.nds.dbutil.ConnectionManager;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DeliveryDaoImpl implements DeliveryDao {

	String except;

	@Override
	public Delivery findById(int dpid) {
		Delivery delivery = null;
		Connection conn = ConnectionManager.getConnection();
		String strSQL = "select * from  DeliveryPerson where dpid = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(strSQL);
			pstmt.setInt(1, dpid);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {

				delivery = new Delivery();
				delivery.setDpid(rs.getInt("dpid"));
				delivery.setDpname(rs.getString("dpName"));
				delivery.setDpContactNo(rs.getInt("dpContactNo"));
			}
			pstmt.close();
			rs.close();
		} catch (SQLException except) {
			// TODO Auto-generated catch block
			except.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}

		return delivery;
	}

	@Override
	public Delivery findByName(String dpName) {
		Delivery delivery = null;
		Connection conn = ConnectionManager.getConnection();
		String strSQL = "select * from  DeliveryPerson where dpName = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(strSQL);
			pstmt.setString(1, dpName);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {

				delivery = new Delivery();
				delivery.setDpid(rs.getInt("dpid"));
				delivery.setDpname(rs.getString("dpName"));
				delivery.setDpContactNo(rs.getInt("dpContactNo"));
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}

		return delivery;
	}

	@Override
	public List<Delivery> findAll() {

		List<Delivery> Deliveryp = new ArrayList<>();
		Connection conn = ConnectionManager.getConnection();
		String strSQL = "select * from DeliveryPerson";
		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(strSQL);
			while (rs.next()) {
				Delivery delivery = new Delivery();

				delivery.setDpid(rs.getInt("dpid"));
				delivery.setDpname(rs.getString("dpName"));
				delivery.setDpContactNo(rs.getInt("dpContactNo"));

				Deliveryp.add(delivery);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}

		return Deliveryp;
	}

	@Override
	public int update(Delivery delivery) {
		int count = 0;
		Connection conn = ConnectionManager.getConnection();
		String strSQL = "update DeliveryPerson set dpName=?, dpContactNo=? WHERE dpid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(strSQL);
			pstmt.setString(1, delivery.getDpname());
			pstmt.setInt(2, delivery.getDpContactNo());
			pstmt.setInt(3, delivery.getDpid());
			count = pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionManager.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public int addDP(Delivery delivery) {
		int count = 0;
		Connection conn = ConnectionManager.getConnection();
		String strSQL = "insert into DeliveryPerson (dpName, dpContactNo)" + "values(?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(strSQL);
			//pstmt.setInt(1, delivery.getDpid());
			pstmt.setString(1, delivery.getDpname());
			pstmt.setInt(2, delivery.getDpContactNo());
			pstmt.executeUpdate();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			ConnectionManager.closeConnection(conn);
		}
		// TODO Auto-generated method stub
		return count;

	}

	@Override
	public int delDPById(int dpid) {
		int count = 0;
		Connection conn = ConnectionManager.getConnection();
		String strSQL = "delete from DeliveryPerson where dpid=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(strSQL);
			pstmt.setInt(1, dpid);
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

	@Override
	public int delDPByName(String dpname) {
		int count = 0;
		Connection conn = ConnectionManager.getConnection();
		String strSQL = "delete from DeliveryPerson where dpName=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(strSQL);
			pstmt.setString(1, dpname);
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

}