package com.demo.uds.emartorder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.demo.uds.emartorder.controller.OrdersExecutionController;
import com.demo.uds.emartorder.repo.OrderRepository;
import com.demo.uds.emartorder.service.OrderService;
import com.demo.uds.emartorder.service.PaymentExecutionService;
import com.demo.uds.emartorder.service.PaymentService;

@SpringBootTest
class OrderServiceApplicationTests {

	@InjectMocks
	private OrdersExecutionController ordersController = new OrdersExecutionController();

	@Mock
	private OrderRepository orderRepo;
	
	@Mock
	private PaymentService paymentService;
	
	private PaymentExecutionService executionService = new PaymentExecutionService();
	@Mock
	private OrderService orderService = new OrderService(orderRepo, paymentService, executionService);
	
	@BeforeAll
	public static void init(){
		OrderServiceApplicationTests testClass = new OrderServiceApplicationTests();
		MockitoAnnotations.openMocks(testClass);
	}
	
	@Test
	public void doNotProcessEmptyOrderList() {
		ResponseEntity<?> result = ordersController.executeOrder(null);
		assertThat(result.getStatusCode().equals(HttpStatus.BAD_REQUEST));
	}

	/*
	  In this service we are mainly saving the details in the DB and not possible as of now to test somehow
	   1) Actual Payment Execution...third party hookup to charge the customer
	   2) Saving Payment details in DB
	   3) Saving Orders details in DB
	   
	   If in actual project perhaps we will checking that all details are there pertaining to payments etc.
	   
	 */
}
