package com.usecase.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.usecase.Booking;
import com.usecase.BookingRepository;
import com.usecase.Customer;
import com.usecase.CustomerRepository;
import com.usecase.EmbeddedCustomer;
import com.usecase.Vehicle;
import com.usecase.VehicleRepository;
import com.usecase.reqresp.BookingReqData;
import com.usecase.reqresp.BookingRequest;
import com.usecase.reqresp.BookingRespData;
import com.usecase.reqresp.BookingResponce;
import com.usecase.reqresp.CustomerReqData;
import com.usecase.reqresp.CustomerRequest;
import com.usecase.reqresp.CustomerRespData;
import com.usecase.reqresp.CustomerResponce;



@Service
@Transactional
public class Servicez {

	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Autowired
	BookingRepository bookingRepository;

	public String getCustomerResponce(CustomerRequest customerRequest) {

		CustomerResponce responce = new CustomerResponce();
		CustomerRespData respData = new CustomerRespData();
		String responceStr = "Customer Created succesfully in DB";

		for (CustomerReqData custReq : customerRequest.getCustomerRequestData()) {
			EmbeddedCustomer customer = new EmbeddedCustomer();
			customer.setCus_id(custReq.getCus_id());
			customer.setCus_name(custReq.getCus_name());
			Customer customerObj = new Customer();
			customerObj.setCustomer(customer);
			customerRepository.save(customerObj);
		}
		respData.setStatusUpdate(responceStr);
		responce.getCustomerRespData().add(respData);
		return responceStr;

	}
	
public String getBookingResponce(BookingRequest bookingRequest){
	
	BookingResponce resp = new BookingResponce();
	BookingRespData e = new BookingRespData();
	//e.setBooking_id(1);
	try{
		for(BookingReqData bookingData : bookingRequest.getBookingReqData()){
			
			if(bookingData.getSeat()<=5){
				Booking booking = new Booking();
				booking.setCust_name(bookingData.getCust_name());
				booking.setRoute(bookingData.getRoute());
				booking.setVehicle_name(bookingData.getVehicle_name());
				booking.setSeat(bookingData.getSeat());
				bookingRepository.save(booking);
				resp.getBookingRespData().add(e);
				return "Booking Confirm";
			}}
		return "No seat available, Try seat no : 5 or below";
	}
	catch(Exception ex){
		//ex.printStackTrace();
		//return "Seat booked,  Try other seat ";
		
		return ex.getMessage();
	}
	
	}
	
	public List<Customer> getAll(){
		List<Customer> ListOfCust = customerRepository.findAll();
		return ListOfCust;
	}
	
	public List<Vehicle> getAllVehicle(){
		List<Vehicle> ListOfVehicle = vehicleRepository.findAll();
		return ListOfVehicle;
	}
	
	public List<Booking> getAllBooking(){
		List<Booking> ListOfBooking = bookingRepository.findAll();
		return ListOfBooking;
	}
	
	
	
	public String createVehicle(){
		Vehicle vehicle = new Vehicle();
	      vehicle.setNoSeats(5);
	      vehicle.setVehicleName("SRS");
	      vehicle.setRoute("BLR-CBE");
	      vehicleRepository.save(vehicle);
	      return "vehicle created" + vehicle.getVehicleId();
	}
	
	

}
