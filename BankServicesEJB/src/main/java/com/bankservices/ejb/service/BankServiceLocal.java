package com.bankservices.ejb.service;

import java.util.List;

import javax.ejb.Local;
import javax.jws.WebMethod;
import javax.jws.WebService;

import com.bankservices.entity.Bank;

@Local
public interface BankServiceLocal {

	public void save(Bank bank);
	public List<Bank> getAll();
	public Bank getById(int id);
	public void update(Bank bank);
	public void delete(int id);
}
