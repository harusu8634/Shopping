package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class ItemDao {
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/shopping";
	private final String DB_USER = "root";
	private final String DB_PASS = "Harusu@1316";
	
	public List<Item> findAll() {
		List<Item> itemList = new ArrayList<>();
		
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM item ORDER BY KIND DESC";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			ResultSet rs = pStmt.executeQuery();
			
			while (rs.next()) {
				int id = rs.getInt("ID");
				String name = rs.getString("NAME");
				String kind = rs.getString("KIND");
				Item item = new Item(id, name, kind);
				itemList.add(item);
		}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return itemList;
	}
	
	public void insertOne(Item item) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "INSERT INTO item (NAME, KIND) VALUES (?, ?)"; 
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, item.getName());
			pStmt.setString(2, item.getKind());
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Item findOne(int id) {
		Item item = null;
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			String sql = "SELECT * FROM item WHERE ID = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()) {
				String name = rs.getString("NAME");
				String kind = rs.getString("KIND");
				item = new Item(id, name, kind);
			}
			} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return item;
	}
	
	public void updateOne(Item item) {
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "UPDATE item SET name = ?, kind = ? WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, item.getName());
			pStmt.setString(2, item.getKind());
			pStmt.setInt(3, item.getId());
			pStmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteOne(int id) {
		try(Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)){
			String sql = "DELETE FROM item WHERE id = ?";
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setInt(1, id);
			pStmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
