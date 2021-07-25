package com.demo.uds.emartorder.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.uds.emartorder.entity.Payment;
import com.demo.uds.emartorder.repo.PaymentRepository;

/*
PaymentService : 
	1) Responsible for persisting payment in the DB 
	2) Also fetch payment details based on order id
*/

@Service
public class PaymentService {

	private PaymentRepository paymentRepo;
	
	@Autowired
	public PaymentService(PaymentRepository repository) {
		this.paymentRepo = repository;
	}
	
	public Payment findByOrderId(String userid){
		return paymentRepo.findByOrderId(userid);
	}
	
	public void save(Payment payment){
		paymentRepo.save(payment);
	}
}