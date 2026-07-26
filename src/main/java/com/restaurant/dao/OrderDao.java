package com.restaurant.dao;

import java.util.List;
<<<<<<< HEAD
import com.restaurant.dto.Orders;

public interface OrderDao {
    void addOrders(Orders order);
    Orders getById(Integer order_id);
    List<Orders> getAllOrders();
    List<Orders> getAllorder_item();
    List<Orders> getOrdersByUserId(Integer user_id);
    void updateOrder(Orders order);
    void deleteOrder(Integer order_id);
}
=======
import com.restaurant.dto.OrdersDTO;

public interface OrderDao {
	void addOrders(OrdersDTO order);
	OrdersDTO getById(Integer order_id);
	List<OrdersDTO> getAllorder_item();
	void updateOrder(OrdersDTO order);
	void deleteOrder(Integer order_id);
}
>>>>>>> 5510ab10c20216bd9875970f3b8979b74c348f21
