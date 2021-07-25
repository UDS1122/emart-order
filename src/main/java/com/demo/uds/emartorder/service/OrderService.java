package com.demo.uds.emartorder.service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.uds.emartorder.entity.Orders;
import com.demo.uds.emartorder.entity.Payment;
import com.demo.uds.emartorder.repo.OrderRepository;
import com.demo.uds.emartorder.utils.PaymentTypes;

/*
 	OrderService : 
 		1) Receives the list of orders from catalog-service
 		2) payment execution service responsible for carrying out the payment
 		3) payment service for saving the payment details in the databse
 		4) List of orders saved in database
 */

@Service
public class OrderService {

	private OrderRepository orderRepo;
	private PaymentService paymentService;
	private PaymentExecutionService paymentExecution;
	
	@Autowired
	public OrderService(OrderRepository repository, PaymentService paymentService, PaymentExecutionService payExecutionService) {
		this.orderRepo = repository;
		this.paymentService = paymentService;
		this.paymentExecution = payExecutionService;
	}
	
	public List<Orders> findByUserId(String userid){
		return orderRepo.findByUserId(userid);
	}
	
	public String save(List<Orders> orders){
		final Payment payment = new Payment();
		payment.setMethod(PaymentTypes.CREDIT_CARD.toString());
		payment.setPaymentdate(Date.valueOf(LocalDate.now(ZoneId.systemDefault())));
		payment.setAmount(orders.stream().collect(Collectors.summingDouble(o -> o.getAmount())));
		payment.setOrderid(orders.get(0).getOrderid());
		
		paymentService.save(paymentExecution.pay(payment));
		orderRepo.saveAll(orders);
		
		return "Order "+payment.getOrderid()+" : "+payment.getStatus();
	}
}