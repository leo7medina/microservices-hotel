package com.leodev.reservations.controller;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.leodev.reservations.config.ReservationsConfiguration;
import com.leodev.reservations.model.ReservationsProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leodev.reservations.model.Reservation;
import com.leodev.reservations.services.IReservationService;

@RestController
public class ReservationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

	@Autowired
	private IReservationService service;

	@Autowired
	private ReservationsConfiguration reservationsConfiguration;

	@GetMapping("/reservations")
	public List<Reservation> search(){
		LOGGER.info("inicio metodo search");
		return (List<Reservation>) this.service.search();	
	}

	@GetMapping("/reservations/read/properties")
	public String getProperties() throws JsonProcessingException {
		LOGGER.info("inicio metodo getProperties");
		ObjectWriter owj = new ObjectMapper().writer().withDefaultPrettyPrinter();
		ReservationsProperties reservationsProperties = new ReservationsProperties();
		reservationsProperties.setMsg(reservationsConfiguration.getMsg());
		reservationsProperties.setBuildVersion(reservationsConfiguration.getBuildVersion());
		reservationsProperties.setMailDetails(reservationsConfiguration.getMailDetails());
		return owj.writeValueAsString(reservationsProperties);
	}

}
