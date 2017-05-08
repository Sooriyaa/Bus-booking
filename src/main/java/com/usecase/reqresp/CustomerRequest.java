package com.usecase.reqresp;

import java.util.ArrayList;
import java.util.List;

public class CustomerRequest {
	
	public List<CustomerReqData> customerRequestData;

	public List<CustomerReqData> getCustomerRequestData() {
		if(customerRequestData == null){
			customerRequestData = new ArrayList<CustomerReqData>();
		}
		return customerRequestData;
	}

	/*public void setCustomerRequestData(List<CustomerReqData> customerRequestData) {
		this.customerRequestData = customerRequestData;
	}*/
	
	

}
