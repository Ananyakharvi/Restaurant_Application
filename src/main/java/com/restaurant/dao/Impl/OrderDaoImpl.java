package com.restaurant.dao.impl;   // ✅ FIXED (lowercase)

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.restaurant.dao.OrderDao;
import com.restaurant.dto.Orders;   // ✅ USING Orders (NOT DTO)
import com.restaurant.utility.Connector;

public class OrderDaoImpl implements OrderDao {

    private Connection con;

    public OrderDaoImpl() {
        this.con = Connector.requestConnection();
        initTable();
    }

    private Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                con = Connector.requestConnection();
                initTable();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    // ✅ AUTO CREATE TABLE
    private void initTable() {
        try (Connection conn = Connector.requestConnection();
             Statement stmt = conn.createStatement()) {

            String sql = "CREATE TABLE IF NOT EXISTS orders ("
                    + "order_id INT AUTO_INCREMENT PRIMARY KEY, "
                    + "user_id INT, "
                    + "reserve_id INT, "
                    + "chief_id INT, "
                    + "subtotal DOUBLE, "
                    + "gst DOUBLE, "
                    + "total_amt DOUBLE, "
                    + "order_date DATE, "
                    + "order_status VARCHAR(50))";

            stmt.execute(sql);

        } catch (Exception e) {
            System.out.println("⚠️ Table creation skipped: " + e.getMessage());
        }
    }

    // ➕ ADD ORDER
    @Override
    public void addOrders(Orders order) {

        String sql = "INSERT INTO orders(user_id,reserve_id,chief_id,subtotal,gst,total_amt,order_date,order_status) VALUES(?,?,?,?,?,?,?,?)";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            ps.setObject(1, order.getUser_id());
            ps.setObject(2, order.getReserve_id());
            ps.setObject(3, order.getChief_id());
            ps.setObject(4, order.getSubtotal());
            ps.setObject(5, order.getGst());
            ps.setObject(6, order.getTotal_amt());
            ps.setDate(7, order.getOrder_date());
            ps.setString(8, order.getOrder_status());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                order.setOrder_id(rs.getInt(1));
            }

            System.out.println("✅ Order Added ID: " + order.getOrder_id());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔍 GET BY ID
    @Override
    public Orders getById(Integer order_id) {

        Orders order = null;

        try {
            PreparedStatement ps = getConnection().prepareStatement(
                    "SELECT * FROM orders WHERE order_id=?");

            ps.setInt(1, order_id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                order = mapRow(rs);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return order;
    }

    // 📋 GET ALL
    @Override
    public List<Orders> getAllOrders() {

        List<Orders> list = new ArrayList<>();

        try {
            PreparedStatement ps = getConnection().prepareStatement("SELECT * FROM orders");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapRow(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Orders> getAllorder_item() {
        return getAllOrders();
    }

    // 👤 GET BY USER ID
    @Override
    public List<Orders> getOrdersByUserId(Integer user_id) {

        List<Orders> list = new ArrayList<>();

        try {
            PreparedStatement ps = getConnection().prepareStatement(
                    "SELECT * FROM orders WHERE user_id=?");

            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(mapRow(rs));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // ✏️ UPDATE
    @Override
    public void updateOrder(Orders order) {

        String sql = "UPDATE orders SET user_id=?, reserve_id=?, chief_id=?, subtotal=?, gst=?, total_amt=?, order_date=?, order_status=? WHERE order_id=?";

        try {
            PreparedStatement ps = getConnection().prepareStatement(sql);

            ps.setObject(1, order.getUser_id());
            ps.setObject(2, order.getReserve_id());
            ps.setObject(3, order.getChief_id());
            ps.setObject(4, order.getSubtotal());
            ps.setObject(5, order.getGst());
            ps.setObject(6, order.getTotal_amt());
            ps.setDate(7, order.getOrder_date());
            ps.setString(8, order.getOrder_status());
            ps.setObject(9, order.getOrder_id());

            ps.executeUpdate();

            System.out.println("✅ Order Updated: " + order.getOrder_id());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ❌ DELETE
    @Override
    public void deleteOrder(Integer order_id) {

        try {
            PreparedStatement ps = getConnection().prepareStatement(
                    "DELETE FROM orders WHERE order_id=?");

            ps.setInt(1, order_id);
            ps.executeUpdate();

            System.out.println("✅ Order Deleted: " + order_id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 🔁 COMMON MAPPING METHOD
    private Orders mapRow(ResultSet rs) throws SQLException {

        Orders o = new Orders();

        o.setOrder_id(rs.getInt("order_id"));
        o.setUser_id(rs.getInt("user_id"));
        o.setReserve_id(rs.getInt("reserve_id"));
        o.setChief_id(rs.getInt("chief_id"));
        o.setSubtotal(rs.getDouble("subtotal"));
        o.setGst(rs.getDouble("gst"));
        o.setTotal_amt(rs.getDouble("total_amt"));
        o.setOrder_date(rs.getDate("order_date"));
        o.setOrder_status(rs.getString("order_status"));

        return o;
    }
}