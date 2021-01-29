package com.bankservices.ejb.dao;

import java.util.List;

import javax.ejb.Local;

import com.bankservices.entity.Bank;

@Local
public interface BankDAOLocal {

	public void save(Bank bank);
	public List<Bank> getAll();
	public Bank getById(int id);
	public void update(Bank bank);
	public void delete(int id);
}
