package com.usecase;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class EmbeddedCustomer  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "cus_name")
	public String cus_name;
	
	@Column(name = "cus_id")
	private String cus_id;
	
	public String getCus_name() {
		return cus_name;
	}

	public void setCus_name(String cus_name) {
		this.cus_name = cus_name;
	}

	public String getCus_id() {
		return cus_id;
	}

	public void setCus_id(String cus_id) {
		this.cus_id = cus_id;
	}

	public EmbeddedCustomer(String cus_name, String cus_id) {
		super();
		this.cus_name = cus_name;
		this.cus_id = cus_id;
	}

	public EmbeddedCustomer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cus_id == null) ? 0 : cus_id.hashCode());
		result = prime * result + ((cus_name == null) ? 0 : cus_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmbeddedCustomer other = (EmbeddedCustomer) obj;
		if (cus_id == null) {
			if (other.cus_id != null)
				return false;
		} else if (!cus_id.equals(other.cus_id))
			return false;
		if (cus_name == null) {
			if (other.cus_name != null)
				return false;
		} else if (!cus_name.equals(other.cus_name))
			return false;
		return true;
	}

	
	

	
	
	

}
