package com.bankservices.ejb.dtos;

import java.util.Date;

public class BranchOfficeDTO {

	private int id;
	private String officeName;
	private Date registrationDate;
	
	public BranchOfficeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BranchOfficeDTO(int id, String officeName, Date registrationDate) {
		super();
		this.id = id;
		this.officeName = officeName;
		this.registrationDate = registrationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "BranchOfficeDTO [id=" + id + ", officeName=" + officeName + ", registrationDate=" + registrationDate
				+ "]";
	}
}
