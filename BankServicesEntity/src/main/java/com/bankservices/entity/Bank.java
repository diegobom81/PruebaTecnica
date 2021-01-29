package com.bankservices.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "bank")
@NamedQueries({
	@NamedQuery(
			name = "Bank.getAll",
			query = "FROM Bank b"
	),
	@NamedQuery(
			name = "Bank.getById",
			query = "FROM Bank b where b.id = :id"
	)
})
public class Bank implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty
	private int id;
	
	@Column(name = "bank_name", nullable = false)
	@JsonProperty
	private String bankName;
	
	@Column(name = "registration_date", nullable = false)
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date registrationDate;

	@OneToMany(mappedBy = "bank", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonProperty
	private List<BranchOffice> offices = new ArrayList<BranchOffice>();

	public Bank() {}

	public Bank(int id) {
		super();
		this.id = id;
	}

	public Bank(int id, String bankName, Date registrationDate) {
		super();
		this.id = id;
		this.bankName = bankName;
		this.registrationDate = registrationDate;
	}

	public Bank(int id, String bankName, Date registrationDate, List<BranchOffice> offices) {
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
	
	public List<BranchOffice> getOffices() {
		return offices;
	}

	public void setOffices(List<BranchOffice> offices) {
		this.offices = offices;
	}

	@Override
	public String toString() {
		return "Bank [id=" + id + ", bankName=" + bankName + ", registrationDate=" + registrationDate + ", offices="
				+ offices + "]";
	}
	
	

}
