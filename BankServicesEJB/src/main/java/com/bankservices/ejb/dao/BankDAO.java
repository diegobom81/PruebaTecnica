package com.bankservices.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.bankservices.entity.Bank;

/**
 * Session Bean implementation class BankDAO
 */
@Stateless
public class BankDAO implements BankDAOLocal {

    public BankDAO() {}
    
    @PersistenceContext(unitName = "BankEntityPU")
    private EntityManager em;

	@Override
	public void save(Bank bank) {
		em.persist(bank);
	}

	@Override
	public List<Bank> getAll() {
		TypedQuery<Bank> query = em.createNamedQuery("Bank.getAll", Bank.class);
		
		return query.getResultList();
	}

	@Override
	public Bank getById(int id) {
		TypedQuery<Bank> query = em.createNamedQuery("Bank.getById", Bank.class);
		query.setParameter("id", id);
		
		Bank bank = (Bank) query.getSingleResult();
		bank.getOffices();
		
		return bank;
	}

	@Override
	public void update(Bank bank) {
		Bank bankToUpdate = getById(bank.getId());
		if (bankToUpdate != null) {
			bankToUpdate.setBankName(bank.getBankName());
			bankToUpdate.setOffices(bank.getOffices());
			
			em.merge(bankToUpdate);
		} else {
			System.out.println("Bank Not Found");
		}
	}

	@Override
	public void delete(int id) {
		em.remove(em.merge(new Bank(id)));
	}
}
