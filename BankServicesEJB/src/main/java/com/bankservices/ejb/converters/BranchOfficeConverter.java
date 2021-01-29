package com.bankservices.ejb.converters;

import java.util.ArrayList;
import java.util.List;

import com.bankservices.ejb.converters.AbstractConverter;
import com.bankservices.ejb.dtos.BranchOfficeDTO;
import com.bankservices.entity.BranchOffice;

public class BranchOfficeConverter extends AbstractConverter<BranchOffice, BranchOfficeDTO>{

	@Override
	public BranchOfficeDTO convertEntityToDTO(BranchOffice entity) {
		BranchOfficeDTO dto = new BranchOfficeDTO(entity.getId(), entity.getOfficeName(), entity.getRegistrationDate());
		return dto;
	}

	@Override
	public BranchOffice convertDTOToEntity(BranchOfficeDTO dto) {
		BranchOffice entity = new BranchOffice(dto.getId(), dto.getOfficeName(), dto.getRegistrationDate());
		return entity;
	}

	@Override
	public List<BranchOfficeDTO> convertEntityListToDTOList(List<BranchOffice> entities) {
		List<BranchOfficeDTO> dtos = new ArrayList<BranchOfficeDTO>();
		for (BranchOffice entity : entities) {
			dtos.add(
				new BranchOfficeDTO(entity.getId(), entity.getOfficeName(), entity.getRegistrationDate())
			);
		}
		
		return dtos;
	}

	@Override
	public List<BranchOffice> convertDTOListToEntityList(List<BranchOfficeDTO> dtos) {
		List<BranchOffice> entities = new ArrayList<BranchOffice>();
		for (BranchOfficeDTO dto : dtos) {
			entities.add(
				new BranchOffice(dto.getId(), dto.getOfficeName(), dto.getRegistrationDate())
			);
		}
		
		return entities;
	}

}
