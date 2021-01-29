package com.bankservices.ejb.service;

import java.util.List;

import javax.ejb.Local;

import com.bankservices.entity.PaymentOrder;

@Local
public interface PaymentOrderServiceLocal {

	public void save(PaymentOrder order);
	public List<PaymentOrder> getOrdersByOfficeIdAndCoin(int officeId, String coin);
	public PaymentOrder getById(int id);
	public void update(PaymentOrder order);
	public void delete(int id);
}
