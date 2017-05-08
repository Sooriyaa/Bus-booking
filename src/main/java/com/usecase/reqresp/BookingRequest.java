package com.usecase.reqresp;

import java.util.ArrayList;
import java.util.List;

public class BookingRequest {
	
	public List<BookingReqData> bookingReqData;

	public List<BookingReqData> getBookingReqData() {
		if(bookingReqData == null){
			bookingReqData = new ArrayList<BookingReqData>();
		}
		return bookingReqData;
	}

}
