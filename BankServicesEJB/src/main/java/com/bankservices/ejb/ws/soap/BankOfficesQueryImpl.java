package com.bankservices.ejb.ws.soap;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import com.bankservices.ejb.converters.EspecificBankConverter;
import com.bankservices.ejb.dtos.EspecificBankDTO;
import com.bankservices.ejb.service.BankServiceLocal;
import com.bankservices.entity.Bank;

@Stateless
@WebService(endpointInterface = "com.bankservices.ejb.ws.soap.BankOfficesQueryWS")
public class BankOfficesQueryImpl implements BankOfficesQueryWS {

	@EJB
	private BankServiceLocal bankService;
	
	private EspecificBankConverter especificBankConverter;
	
	public BankOfficesQueryImpl() {
		especificBankConverter = new EspecificBankConverter();
	}
	
	@Override
	public EspecificBankDTO getOfficesByBank(int bankId) {
		Bank bank = bankService.getById(bankId);
		EspecificBankDTO dto = especificBankConverter.convertEntityToDTO(bank);
		return dto;
	}

}
