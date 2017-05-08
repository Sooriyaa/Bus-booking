package com.usecase;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = "Customer")
@Table(name = "customer")
public class Customer {
	
	@EmbeddedId
	private EmbeddedCustomer customer;

	public EmbeddedCustomer getCustomer() {
		return customer;
	}

	public void setCustomer(EmbeddedCustomer customer) {
		this.customer = customer;
	}
	
	

}
