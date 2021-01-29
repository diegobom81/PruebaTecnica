package com.bankservices.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "branch_office")
@NamedQueries({
	@NamedQuery(
			name = "BranchOffice.getAll",
			query = "FROM BranchOffice b"
	),
	@NamedQuery(
			name = "BranchOffice.getById",
			query = "FROM BranchOffice b where b.id = :id"
	)
})
public class BranchOffice implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty
	private int id;
	
	@Column(name = "office_name", nullable = false)
	@JsonProperty
	private String officeName;
	
	@Column(name = "registration_date", nullable = false)
	@JsonProperty
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date registrationDate;
	
	@ManyToOne
	@JoinColumn(name = "bank_id")
	@JsonIgnore
	private Bank bank;

	public BranchOffice() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BranchOffice(int id) {
		super();
		this.id = id;
	}
	
	

	public BranchOffice(int id, String officeName, Date registrationDate) {
		super();
		this.id = id;
		this.officeName = officeName;
		this.registrationDate = registrationDate;
	}

	public BranchOffice(int id, String officeName, Date registrationDate, Bank bank) {
		super();
		this.id = id;
		this.officeName = officeName;
		this.registrationDate = registrationDate;
		this.bank = bank;
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

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	@Override
	public String toString() {
		return "BranchOffice [id=" + id + ", officeName=" + officeName + ", registrationDate=" + registrationDate
				+ ", bank=" + bank + "]";
	}
}
