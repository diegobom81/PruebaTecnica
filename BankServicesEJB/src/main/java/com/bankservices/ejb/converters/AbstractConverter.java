package com.bankservices.ejb.converters;

import java.util.List;

public abstract class AbstractConverter<Entity, DTO> {

	public abstract DTO convertEntityToDTO(Entity entity);
	public abstract Entity convertDTOToEntity(DTO dto);
	public abstract List<DTO> convertEntityListToDTOList(List<Entity> entities);
	public abstract List<Entity> convertDTOListToEntityList(List<DTO> dtos);
}
