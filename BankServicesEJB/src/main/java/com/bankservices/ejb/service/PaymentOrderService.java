package com.bankservices.ejb.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.bankservices.ejb.dao.PaymentOrderDAOLocal;
import com.bankservices.entity.PaymentOrder;

/**
 * Session Bean implementation class PaymentOrderService
 */
@Stateless
public class PaymentOrderService implements PaymentOrderServiceLocal {

    public PaymentOrderService() {}

    @EJB
    private PaymentOrderDAOLocal orderDAO;
    
	@Override
	public void save(PaymentOrder order) {
		order.setRegistrationDate(new Date());
		order.setOffice(order.getOffice());
		orderDAO.save(order);
	}

	@Override
	public List<PaymentOrder> getOrdersByOfficeIdAndCoin(int officeId, String coin) {
		return orderDAO.getOrdersByOfficeIdAndCoin(officeId, coin);
	}

	@Override
	public PaymentOrder getById(int id) {
		return orderDAO.getById(id);
	}

	@Override
	public void update(PaymentOrder order) {
		order.setRegistrationDate(new Date());
		order.setOffice(order.getOffice());
		orderDAO.update(order);
	}

	@Override
	public void delete(int id) {
		orderDAO.delete(id);
	}

}
