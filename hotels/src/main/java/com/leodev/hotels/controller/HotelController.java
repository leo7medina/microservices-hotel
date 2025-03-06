package com.leodev.hotels.controller;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.leodev.hotels.config.HotelsConfiguration;
import com.leodev.hotels.model.HotelProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leodev.hotels.model.Hotel;
import com.leodev.hotels.services.IHotelService;

@RestController
public class HotelController {
	
	@Autowired
	private IHotelService service;

	@Autowired
	private HotelsConfiguration hotelsConfiguration;

	@GetMapping("hotels")
	public List<Hotel> search(){
		return (List<Hotel>) this.service.search();	
	}

	@GetMapping("/hotels/read/properties")
	public String getProperties() throws JsonProcessingException {
		ObjectWriter owj = new ObjectMapper().writer().withDefaultPrettyPrinter();
		HotelProperties hotelProperties = new HotelProperties();
		hotelProperties.setMsg(hotelsConfiguration.getMsg());
		hotelProperties.setBuildVersion(hotelsConfiguration.getBuildVersion());
		hotelProperties.setMailDetails(hotelsConfiguration.getMailDetails());
		return owj.writeValueAsString(hotelProperties);
	}

}
