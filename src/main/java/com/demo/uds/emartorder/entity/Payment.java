package com.demo.uds.emartorder.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/*
	Payment : 
		1) Mapped with table Payment in database
		2) Has details payment details like amount, payment type etc. 
*/

@Entity
@Data
public class Payment {

	@Id
	@GeneratedValue
    private Integer id;
	
	@Column
	private String orderid;
	
	@Column
    private Double amount;
	
	@Column
	@JsonProperty
    private String status;

	@Column
    private Date paymentdate;

	@Column
    private String method;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getPaymentdate() {
		return paymentdate;
	}

	public void setPaymentdate(Date paymentdate) {
		this.paymentdate = paymentdate;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
}