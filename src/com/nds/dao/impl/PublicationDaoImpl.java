package com.nds.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.nds.bean.Publication;
import com.nds.dao.PublicationDao;
import com.nds.dbutil.ConnectionManager;

public class PublicationDaoImpl implements PublicationDao {

	@Override
	public Publication findById(int id) {
		Publication publication = null;

		Connection conn = ConnectionManager.getConnection();
		String strSQL = "select * from Publication where pub_id = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(strSQL);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				publication = new Publication();
				publication.setPub_id(rs.getInt("pub_id"));
				publication.setPname(rs.getString("Pname"));
				publication.setPrice(rs.getString("price"));
				publication.setNumOfStock(rs.getInt("numOfStock"));
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}

		return publication;
	}

	@Override
	public Publication findByName(String Pname) {
		Publication publication = null;

		Connection conn = ConnectionManager.getConnection();
		String strSQL = "select * from Publication where Pname = ?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(strSQL);
			pstmt.setString(1, Pname);
			;
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				publication = new Publication();
				publication.setPub_id(rs.getInt("pub_id"));
				publication.setPname(rs.getString("Pname"));
				publication.setPrice(rs.getString("price"));
				publication.setNumOfStock(rs.getInt("numOfStock"));
			}
			pstmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}

		return publication;
	}

	@Override
	public List<Publication> findAll() {
		// TODO Auto-generated method stub
		List<Publication> publications = new ArrayList<>();

		Connection conn = ConnectionManager.getConnection();
		String strSQL = "select * from Publication";

		try {
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(strSQL);
			while (rs.next()) {
				Publication publication = new Publication();

				publication.setPub_id(rs.getInt("pub_id"));
				publication.setPname(rs.getString("Pname"));
				publication.setPrice(rs.getString("price"));
				publication.setNumOfStock(rs.getInt("numOfStock"));
				publications.add(publication);
			}
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			ConnectionManager.closeConnection(conn);
		}
		return publications;

	}

	@Override
	public int update(Publication publication) {
		int count = 0;

		Connection conn = ConnectionManager.getConnection();
		String strSQL = "update Publication set Pname=?, numOfStock=?," + " price=? where pub_id=?";

		try {
			PreparedStatement pstmt = conn.prepareStatement(strSQL);
			pstmt.setString(1, publication.getPname());
			pstmt.setInt(2, publication.getNumOfStock());
			pstmt.setString(3, publication.getPrice());
			pstmt.setInt(4, publication.getPub_id());

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
	public int updateStock(int pub_id, int NumOfStock) {
		int count = 0;

		Connection conn = ConnectionManager.getConnection();
		String strSQL = "update Publication set numOfStock=? where pub_id=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(strSQL);
			pstmt.setInt(1, NumOfStock);
			pstmt.setInt(2, pub_id);

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
	public int addPub(Publication publication) {
		// TODO Auto-generated method stub
		int count = 0;
		Connection conn = ConnectionManager.getConnection();
		String strSQL= "insert into Publication(pub_id,Pname,numOfStock,price) "
				+ "values(?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(strSQL);
			pstmt.setInt(1, publication.getPub_id());
			pstmt.setString(2, publication.getPname());
			pstmt.setInt(3, publication.getNumOfStock());
			pstmt.setString(4, publication.getPrice());
			
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

	@Override
	public int delPubById(int id) {   
		// TODO Auto-generated method stub
		int count = 0;
		Connection conn = ConnectionManager.getConnection();
		String srtSQL = "delete from Publication where pub_id=?";
		
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

	@Override
	public int delPubByName(String Pname) {
		int count = 0;
		Connection conn = ConnectionManager.getConnection();
		String srtSQL = "delete from Publication where Pname=?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(srtSQL);
			pstmt.setString(1, Pname);
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

}
