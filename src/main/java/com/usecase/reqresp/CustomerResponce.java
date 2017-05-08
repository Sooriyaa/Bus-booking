package com.usecase.reqresp;

import java.util.ArrayList;
import java.util.List;

public class CustomerResponce {
	
	public List<CustomerRespData> CustomerRespData;

	public List<CustomerRespData> getCustomerRespData() {
		if(CustomerRespData == null){
			CustomerRespData = new ArrayList<CustomerRespData>();
		}
		return CustomerRespData;
	}

	public void setCustomerRespData(List<CustomerRespData> customerRespData) {
		CustomerRespData = customerRespData;
	}

	

}
