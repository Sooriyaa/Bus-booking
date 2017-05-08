package com.usecase;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.usecase.reqresp.BookingReqData;
import com.usecase.reqresp.BookingRequest;
import com.usecase.reqresp.CustomerReqData;
import com.usecase.reqresp.CustomerRequest;
import com.usecase.service.Servicez;



@RestController
@RequestMapping("/customer")
public class Controllerz {

	@Autowired
	Servicez servicez;

	// Creating a new Customer record in DB
	@POST
	@RequestMapping("/createCustomer")
	@ResponseBody
	@Transactional
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public String createCustomer(@RequestBody CustomerRequest customerRequest) {

		// CustomerResponce responce = new CustomerResponce();
		// Processing data in service layer
		String str = servicez.getCustomerResponce(customerRequest);
		return str;
	}
	
	// Creating a new Booking record in DB
		@POST
		@RequestMapping("/createBooking")
		@ResponseBody
		@Transactional
		@Consumes({ MediaType.APPLICATION_JSON })
		@Produces({ MediaType.APPLICATION_JSON })
		public String createBooking(@RequestBody BookingRequest bookingRequest) {

			// CustomerResponce responce = new CustomerResponce();
			// Processing data in service layer
			return servicez.getBookingResponce(bookingRequest);
			
			
		}

	@POST
	@RequestMapping("/createCustomerJson")
	@ResponseBody
	public CustomerRequest createCustomerJson() {
		CustomerRequest req = new CustomerRequest();
		CustomerReqData e = new CustomerReqData();
		e.setCus_id("6");
		e.setCus_name("Navi");
		req.getCustomerRequestData().add(e);
		return req;
	}

	@POST
	@RequestMapping("/createBookingJson")
	@ResponseBody
	public BookingRequest createBookingJson() {
		BookingRequest req = new BookingRequest();
		BookingReqData e = new BookingReqData();
		e.setBooking_id(1);
		e.setCust_name("Kavin");
		e.setRoute("BLR-GOA");
		e.setVehicle_name("KPN");
		e.setSeat(1);
		req.getBookingReqData().add(e);
		return req;
	}

	// Finding all Emp record from DB

	@GET
	@RequestMapping("/findAllCustomer")
	@ResponseBody
	public List<Customer> findAll() {
		return servicez.getAll();
	}

	// Create Vehicle
	@GET
	@RequestMapping("/createVehicle")
	public String createVehicle() {
		// Processing data in service layer

		return servicez.createVehicle();
	}

	// Finding all Vehicle record from DB

	@GET
	@RequestMapping("/findAllVehicle")
	@ResponseBody
	public List<Vehicle> findAllVehicle() {
		return servicez.getAllVehicle();
	}
	
	@GET
	@RequestMapping("/findAllBooking")
	@ResponseBody
	public List<Booking> findAllBooking() {
		return servicez.getAllBooking();
	}

}
