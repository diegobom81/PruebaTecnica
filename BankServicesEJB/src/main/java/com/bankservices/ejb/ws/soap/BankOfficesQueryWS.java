package com.bankservices.ejb.ws.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.bankservices.ejb.dtos.EspecificBankDTO;
import com.bankservices.entity.Bank;

@WebService
public interface BankOfficesQueryWS {

	@WebMethod
	public EspecificBankDTO getOfficesByBank(int bankId);
}
