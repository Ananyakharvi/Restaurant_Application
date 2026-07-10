package com.restaurant.dao;

import java.util.List;

import com.restaurant.dto.O_status;

public interface O_statusDao {
		O_status getById(Integer status_id);
		List<O_status> getAllO_status();
}
