package com.demo.uds.emartorder.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demo.uds.emartorder.entity.Payment;

/*
	PaymentRepository :
		1) Repository providing all methods for saving/fetching payment in database
		2) Extra specific function to fetch payments by Order Id
*/

public interface PaymentRepository extends CrudRepository<Payment, Integer> {
	
	@Query("select p from Payment p where p.orderid = ?1")
	Payment findByOrderId(String userid);
}
