package com.amplesoftech.dress2impressbackend.dao;

import java.util.List;
import com.amplesoftech.dress2impressbackend.dto.OrderDetail;

public interface OrderDetailsDAO 
{
	
	List<OrderDetail> list();
	boolean update(OrderDetail orderDetail);
	boolean delete(OrderDetail orderDetail);
	OrderDetail get(int id);
	List<OrderDetail> listActiveTransactions();
	double totalProfit();

}
