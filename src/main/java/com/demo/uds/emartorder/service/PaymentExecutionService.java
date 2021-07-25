package com.demo.uds.emartorder.service;

import org.springframework.stereotype.Service;

import com.demo.uds.emartorder.entity.Payment;

/*
	PaymentExecutionService : 
		1) Responsible for fulfilling the payment 
		2) In real life this will connect with either in-house or third library for making payment based on the details e.g. Credit Card, Debit Card etc.
		3) As of now hard-coded but in real life it connect to some third party to carry out this operation
*/

@Service
public class PaymentExecutionService {

	public Payment pay(Payment payment) {
		//third party call..we will have to take care synchronization as well...use locks...
		payment.setStatus("Success");//in real world if payment fails then status would be Failed
		return payment;
	}
}