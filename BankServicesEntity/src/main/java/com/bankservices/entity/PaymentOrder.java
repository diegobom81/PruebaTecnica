package com.bankservices.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "payment_order")
@NamedQueries({
	@NamedQuery(
			name = "PaymentOrder.getOrdersByOfficeIdAndCoin",
			query = "SELECT po FROM PaymentOrder po join po.office office where office.id = :officeId and po.coin like :coin"
	),
	@NamedQuery(
			name = "PaymentOrder.getById",
			query = "FROM PaymentOrder po where po.id = :id"
	)
})
public class PaymentOrder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "mount", nullable = false)
	private double mount;
	
	@Column(name = "coin", nullable = false)
	private String coin;
	
	@Column(name = "state", nullable = false)
	private String state;
	
	@Column(name = "registration_date", nullable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm:ss.SSSZ")
	private Date registrationDate;
	
	@ManyToOne
	@JoinColumn(name = "office_id")
	private BranchOffice office; 

	public PaymentOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PaymentOrder(int id) {
		super();
		this.id = id;
	}
	
	public PaymentOrder(int id, double mount, String coin, String state, Date registrationDate, BranchOffice office) {
		super();
		this.id = id;
		this.mount = mount;
		this.coin = coin;
		this.state = state;
		this.registrationDate = registrationDate;
		this.office = office;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMount() {
		return mount;
	}

	public void setMount(double mount) {
		this.mount = mount;
	}

	public String getCoin() {
		return coin;
	}

	public void setCoin(String coin) {
		this.coin = coin;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	public BranchOffice getOffice() {
		return office;
	}

	public void setOffice(BranchOffice office) {
		this.office = office;
	}

	@Override
	public String toString() {
		return "PaymentOrder [id=" + id + ", mount=" + mount + ", coin=" + coin + ", state=" + state
				+ ", registrationDate=" + registrationDate + ", office=" + office + "]";
	}

	
}
