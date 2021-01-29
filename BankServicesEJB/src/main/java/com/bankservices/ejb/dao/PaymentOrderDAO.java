package com.bankservices.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.bankservices.entity.PaymentOrder;

/**
 * Session Bean implementation class PaymentOrderDAO
 */
@Stateless
public class PaymentOrderDAO implements PaymentOrderDAOLocal {


    public PaymentOrderDAO() {}
    
    @PersistenceContext(unitName = "BankEntityPU")
    private EntityManager em;

	@Override
	public void save(PaymentOrder order) {
		em.persist(order);
	}

	@Override
	public List<PaymentOrder> getOrdersByOfficeIdAndCoin(int officeId, String coin) {
		TypedQuery<PaymentOrder> query = em.createNamedQuery("PaymentOrder.getOrdersByOfficeIdAndCoin", PaymentOrder.class);
		query.setParameter("officeId", officeId);
		query.setParameter("coin", "%" + coin.trim().toLowerCase() + "%");
		
		return query.getResultList();
	}

	@Override
	public PaymentOrder getById(int id) {
		TypedQuery<PaymentOrder> query = em.createNamedQuery("PaymentOrder.getById", PaymentOrder.class);
		query.setParameter("id", id);
		
		return query.getSingleResult();
	}

	@Override
	public void update(PaymentOrder order) {
		PaymentOrder orderToUpdate = getById(order.getId());
		if (orderToUpdate != null) {
			orderToUpdate.setCoin(order.getCoin());
			orderToUpdate.setMount(order.getMount());
			orderToUpdate.setState(order.getState());
			
			em.merge(orderToUpdate);
		} else {
			System.out.println("Order not found");
		}
	}

	@Override
	public void delete(int id) {
		em.remove(em.merge(new PaymentOrder(id)));
	}

}
