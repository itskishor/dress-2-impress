package com.amplesoftech.dress2impressbackend.dao;

import com.amplesoftech.dress2impressbackend.dto.OrderItem;

public interface OrderItemDAO
{
	boolean deleteByOrderId(int id);
	public OrderItem get(int id);	
	
}
