package com.bankservices.ejb.converters;

import java.util.ArrayList;
import java.util.List;

import com.bankservices.ejb.converters.AbstractConverter;
import com.bankservices.ejb.dtos.BanksDTO;
import com.bankservices.entity.Bank;

public class BanksConverter extends AbstractConverter<Bank, BanksDTO> {

	@Override
	public BanksDTO convertEntityToDTO(Bank entity) {
		BanksDTO bankDTO = new BanksDTO(entity.getId(), entity.getBankName(), entity.getRegistrationDate());
		return bankDTO;
	}

	@Override
	public Bank convertDTOToEntity(BanksDTO dto) {
		Bank bankEntity = new Bank(dto.getId(), dto.getBankName(), dto.getRegistrationDate());
		return bankEntity;
	}

	@Override
	public List<BanksDTO> convertEntityListToDTOList(List<Bank> entities) {
		List<BanksDTO> dtos = new ArrayList<BanksDTO>();
		for (Bank bankEntity : entities) {
			dtos.add(
				new BanksDTO(bankEntity.getId(), bankEntity.getBankName(), bankEntity.getRegistrationDate())
			);
		}
		
		return dtos;
	}

	@Override
	public List<Bank> convertDTOListToEntityList(List<BanksDTO> dtos) {
		List<Bank> bankEntities = new ArrayList<Bank>();
		for (BanksDTO dto : dtos) {
			bankEntities.add(
				new Bank(dto.getId(), dto.getBankName(), dto.getRegistrationDate())
			);
		}
		
		return bankEntities;
	}

}
