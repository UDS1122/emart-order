package com.demo.uds.emartorder.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demo.uds.emartorder.entity.Orders;

/*
 	OrderRepository :
 		1) Repository providing all methods for saving/fetching orders in database
 		2) Extra specific function to fetch order for the user
 */

public interface OrderRepository extends CrudRepository<Orders, Integer> {
	
	@Query("select o from Orders o where o.userid = ?1")
	List<Orders> findByUserId(String userid);
}
