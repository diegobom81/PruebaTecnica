package com.bankservices.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BanksDTO {

	@JsonProperty
	private int id;
	@JsonProperty
	private String bankName;
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date registrationDate;
	
	public BanksDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BanksDTO(int id, String bankName, Date registrationDate) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.registrationDate = registrationDate;
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
	@Override
	public String toString() {
		return "BanksDTO [id=" + id + ", bankName=" + bankName + ", registrationDate=" + registrationDate + "]";
	}
}
