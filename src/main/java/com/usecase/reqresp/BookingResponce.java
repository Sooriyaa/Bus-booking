package com.usecase.reqresp;

import java.util.ArrayList;
import java.util.List;

public class BookingResponce {
	
	public List<BookingRespData>  bookingRespData;

	public List<BookingRespData> getBookingRespData() {
		if(bookingRespData == null){
			bookingRespData = new ArrayList<BookingRespData>();
		}
		return bookingRespData;
	}

	public void setBookingRespData(List<BookingRespData> bookingRespData) {
		this.bookingRespData = bookingRespData;
	}
	
	
	

}
