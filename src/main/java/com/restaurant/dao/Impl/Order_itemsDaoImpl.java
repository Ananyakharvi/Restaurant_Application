package com.restaurant.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.dao.Order_itemdao;
import com.restaurant.dto.Order_item;
import com.restaurant.utility.Connector;

public class Order_itemsDaoImpl implements Order_itemdao {
    private Connection con;

    public Order_itemsDaoImpl() {
        this.con = Connector.requestConnection();
        initTable();
    }

<<<<<<< HEAD
	   @Override
	   public void addOrder_item(Order_item item) {
		   String query = "INSERT INTO order_item(order_id,menu_id,price,quantity) VALUES(?,?,?,?)";
=======
    private Connection getConnection() {
        try {
            if (this.con == null || this.con.isClosed()) {
                this.con = Connector.requestConnection();
                initTable();
            }
        } catch (SQLException e) {
            this.con = Connector.requestConnection();
        }
        return this.con;
    }
>>>>>>> 83c88f2c65e93704326f89f55fe3120923339eec

    private void initTable() {
        Connection conn = Connector.requestConnection();
        if (conn != null) {
            try (Statement stmt = conn.createStatement()) {
                String createTableSql = "CREATE TABLE IF NOT EXISTS order_item ("
                    + "item_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "order_id INT, "
                    + "menu_id INT, "
                    + "price DOUBLE, "
                    + "quantity INT"
                    + ")";
                stmt.execute(createTableSql);
            } catch (SQLException e) {
                // Table creation deferred
            }
        }
    }

    @Override
    public void addOrder_item(order_item item) {
        Connection conn = getConnection();
        if (conn == null || item == null) return;

        String query = "INSERT INTO order_item(order_id,menu_id,price,quantity) VALUES(?,?,?,?)";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            pstmt.setObject(1, item.getOrder_id());
            pstmt.setObject(2, item.getMenu_id());
            pstmt.setObject(3, item.getPrice());
            pstmt.setObject(4, item.getQuantity() != null ? item.getQuantity() : 1);
            pstmt.executeUpdate();

<<<<<<< HEAD
	   @Override
	   public Order_item getById(Integer item_id) {
		    Order_item item = null;
=======
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                item.setItem_id(rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
>>>>>>> 83c88f2c65e93704326f89f55fe3120923339eec

    @Override
    public order_item getById(Integer item_id) {
        Connection conn = getConnection();
        if (conn == null || item_id == null) return null;

        order_item item = null;
        String query = "SELECT * FROM order_item WHERE item_id=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, item_id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                item = new order_item();
                item.setItem_id(rs.getInt("item_id"));
                item.setOrder_id(rs.getInt("order_id"));
                item.setMenu_id(rs.getInt("menu_id"));
                item.setPrice(rs.getDouble("price"));
                item.setQuantity(rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return item;
    }

<<<<<<< HEAD
	                item = new Order_item();
=======
    @Override
    public List<order_item> getAllorder_item() {
        List<order_item> list = new ArrayList<>();
        Connection conn = getConnection();
        if (conn == null) return list;
>>>>>>> 83c88f2c65e93704326f89f55fe3120923339eec

        String query = "SELECT * FROM order_item";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

<<<<<<< HEAD
	   @Override
	   public List<Order_item> getAllorder_item() {
		   List<Order_item> list = new ArrayList<>();
=======
            while (rs.next()) {
                order_item item = new order_item();
                item.setItem_id(rs.getInt("item_id"));
                item.setOrder_id(rs.getInt("order_id"));
                item.setMenu_id(rs.getInt("menu_id"));
                item.setPrice(rs.getDouble("price"));
                item.setQuantity(rs.getInt("quantity"));
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
>>>>>>> 83c88f2c65e93704326f89f55fe3120923339eec

    @Override
    public List<order_item> getByOrderId(Integer order_id) {
        List<order_item> list = new ArrayList<>();
        Connection conn = getConnection();
        if (conn == null || order_id == null) return list;

        String query = "SELECT * FROM order_item WHERE order_id=?";

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, order_id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                order_item item = new order_item();
                item.setItem_id(rs.getInt("item_id"));
                item.setOrder_id(rs.getInt("order_id"));
                item.setMenu_id(rs.getInt("menu_id"));
                item.setPrice(rs.getDouble("price"));
                item.setQuantity(rs.getInt("quantity"));
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void updateOrder_item(order_item item) {
        Connection conn = getConnection();
        if (conn == null || item == null) return;

<<<<<<< HEAD
	                Order_item item = new Order_item();
=======
        String query = "UPDATE order_item SET order_id=?, menu_id=?, price=?, quantity=? WHERE item_id=?";
>>>>>>> 83c88f2c65e93704326f89f55fe3120923339eec

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setObject(1, item.getOrder_id());
            pstmt.setObject(2, item.getMenu_id());
            pstmt.setObject(3, item.getPrice());
            pstmt.setObject(4, item.getQuantity());
            pstmt.setObject(5, item.getItem_id());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMenu_item(order_item item) {
        updateOrder_item(item);
    }

    @Override
    public void deleteOrder_item(Integer item_id) {
        Connection conn = getConnection();
        if (conn == null || item_id == null) return;

<<<<<<< HEAD
	   @Override
	   public void updateMenu_item(Order_item item) {
		   String query = "UPDATE order_item SET order_id=?, menu_id=?, price=?, quantity=? WHERE item_id=?";

	        try {

	            PreparedStatement pstmt = con.prepareStatement(query);

	            pstmt.setInt(1, item.getOrder_id());
	            pstmt.setInt(2, item.getMenu_id());
	            pstmt.setDouble(3, item.getPrice());
	            pstmt.setInt(4, item.getQuantity());
	            pstmt.setInt(5, item.getItem_id());
                pstmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
	   }

	   @Override
	   public void deleteMenu_item(Integer item_id) {
	       String query = "DELETE FROM order_item WHERE item_id=?";

	        try {

	            PreparedStatement pstmt = con.prepareStatement(query);

	            pstmt.setInt(1, item_id);
                pstmt.executeUpdate();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
		
	   }

	
		
	
=======
        String query = "DELETE FROM order_item WHERE item_id=?";
>>>>>>> 83c88f2c65e93704326f89f55fe3120923339eec

        try {
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, item_id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMenu_item(Integer item_id) {
        deleteOrder_item(item_id);
    }
}
