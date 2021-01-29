package com.bankservices.converters;

import java.util.ArrayList;
import java.util.List;

import com.bankservices.ejb.converters.AbstractConverter;
import com.bankservices.ejb.converters.BranchOfficeConverter;
import com.bankservices.ejb.dtos.EspecificBankDTO;
import com.bankservices.entity.Bank;

public class EspecificBankConverter extends AbstractConverter<Bank, EspecificBankDTO>{

	private BranchOfficeConverter officeConverter;
	
	public EspecificBankConverter() {
		officeConverter = new BranchOfficeConverter();
	}
	
	@Override
	public EspecificBankDTO convertEntityToDTO(Bank entity) {
		EspecificBankDTO dto = new EspecificBankDTO(
				entity.getId(), 
				entity.getBankName(), 
				entity.getRegistrationDate(), 
				officeConverter.convertEntityListToDTOList(entity.getOffices()));
		
		return dto;
	}

	@Override
	public Bank convertDTOToEntity(EspecificBankDTO dto) {
		Bank entity = new Bank(
				dto.getId(), 
				dto.getBankName(), 
				dto.getRegistrationDate(), 
				officeConverter.convertDTOListToEntityList(dto.getOffices()));
		
		return entity;
	}

	@Override
	public List<EspecificBankDTO> convertEntityListToDTOList(List<Bank> entities) {
		List<EspecificBankDTO> dtos = new ArrayList<EspecificBankDTO>();
		for (Bank entity : entities) {
			dtos.add(
				new EspecificBankDTO(
						entity.getId(),
						entity.getBankName(), 
						entity.getRegistrationDate(), 
						officeConverter.convertEntityListToDTOList(entity.getOffices()))
			);
		}
		
		return dtos;
	}

	@Override
	public List<Bank> convertDTOListToEntityList(List<EspecificBankDTO> dtos) {
		List<Bank> entities = new ArrayList<Bank>();
		for (EspecificBankDTO dto : dtos) {
			entities.add(
				new Bank(
						dto.getId(), 
						dto.getBankName(), 
						dto.getRegistrationDate(), 
						officeConverter.convertDTOListToEntityList(dto.getOffices()))
			);
		}
		
		return entities;
	}

}
