package com.bankservices.resources;


import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.bankservices.ejb.converters.BanksConverter;
import com.bankservices.ejb.converters.EspecificBankConverter;
import com.bankservices.ejb.dtos.BanksDTO;
import com.bankservices.ejb.dtos.EspecificBankDTO;
import com.bankservices.ejb.service.BankServiceLocal;
import com.bankservices.entity.Bank;
import com.bankservices.wrapper.WrapperResponse;

@Path("/bank")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Stateless
public class BankController {

	
	@EJB
	private BankServiceLocal bankService;
	
	private BanksConverter banksConverter;
	private EspecificBankConverter especificBankConverter;
	
	public BankController() {
		banksConverter = new BanksConverter();
		especificBankConverter = new EspecificBankConverter();
	}
	
	@GET
	public Response getAllBanks() {
		List<Bank> banks = bankService.getAll();
		List<BanksDTO> dtos = banksConverter.convertEntityListToDTOList(banks);
		if (!banks.isEmpty()) {
			return Response.ok().entity(new WrapperResponse<>(true, "BanksList", dtos)).build();
		} else {
			return Response.status(Status.NOT_FOUND).entity("No data").build();
		}
	}
	
	@GET
	@Path("/{id}")
	public Response getBankById(@PathParam("id")int id) {
		 Bank bank = bankService.getById(id);
		 EspecificBankDTO dto = especificBankConverter.convertEntityToDTO(bank);
		 if (bank != null) {
			 return Response.ok().entity(new WrapperResponse<>(true, "Banco encontrado", dto)).build();
		 } else {
			 return Response.status(Status.NOT_FOUND).entity("No data").build();
		 }
	}
	
	@POST
	public Response insert(Bank bank) {
		bankService.save(bank);
		return Response.ok().entity(new WrapperResponse<>(true, "Banco Creado con Exito", null)).build();
	}
	
	@PUT
	public Response update(Bank bank) {
		bankService.update(bank);
		return Response.ok().entity(new WrapperResponse<>(true, "Banco Actualizado con Exito", null)).build();
	}
	
	@DELETE
	@Path("/{id}")
	public Response delete(@PathParam("id") int id) {
		bankService.delete(id);
		return Response.ok().entity(new WrapperResponse<>(true, "Banco Eliminado con Exito", null)).build();
	}
	
}
