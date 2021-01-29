package com.bankservices.ejb.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.bankservices.ejb.dao.BankDAOLocal;
import com.bankservices.ejb.dao.BranchOfficeDAOLocal;
import com.bankservices.entity.Bank;
import com.bankservices.entity.BranchOffice;

/**
 * Session Bean implementation class BankService
 */
@Stateless
public class BankService implements BankServiceLocal {

    public BankService() {
    }
    
    @EJB
    private BankDAOLocal bankDAO;
    
    @EJB
    private BranchOfficeDAOLocal officeDAO;
    
	@Override
	public void save(Bank bank) {
		bank.setRegistrationDate(new Date());
		for (BranchOffice office : bank.getOffices()) {
			office.setRegistrationDate(new Date());
			office.setBank(bank);
		}
		bankDAO.save(bank);
	}

	@Override
	public List<Bank> getAll() {
		return bankDAO.getAll();
	}

	@Override
	public Bank getById(int id) {
		return bankDAO.getById(id);
	}

	@Override
	public void update(Bank bank) {
		for (BranchOffice office : bank.getOffices()) {
			office.setRegistrationDate(new Date());
			office.setBank(bank);
		}
		bankDAO.update(bank);
	}

	@Override
	public void delete(int id) {
		Bank bankManaged = getById(id);
		if (bankManaged != null) {
			for (BranchOffice office : bankManaged.getOffices()) {
				officeDAO.delete(office.getId());
			}
			bankManaged.getOffices().removeAll(bankManaged.getOffices());
			System.out.println(bankManaged.getOffices().size());
			
			bankDAO.delete(id);
		} else {
			System.out.println("Bank Not Found");
		}
	}

}
