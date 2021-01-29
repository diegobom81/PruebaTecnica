package com.bankservices.ejb.dtos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bankservices.ejb.dtos.BranchOfficeDTO;

public class EspecificBankDTO {

	private int id;
	private String bankName;
	private Date registrationDate;
	private List<BranchOfficeDTO> offices = new ArrayList<BranchOfficeDTO>();
	
	public EspecificBankDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EspecificBankDTO(int id, String bankName, Date registrationDate, List<BranchOfficeDTO> offices) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.registrationDate = registrationDate;
		this.offices = offices;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	public List<BranchOfficeDTO> getOffices() {
		return offices;
	}
	public void setOffices(List<BranchOfficeDTO> offices) {
		this.offices = offices;
	}
	@Override
	public String toString() {
		return "BankDTO [id=" + id + ", bankName=" + bankName + ", registrationDate=" + registrationDate + ", offices="
				+ offices + "]";
	}
}
