package com.leodev.rooms.controller;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.leodev.rooms.config.RoomsConfiguration;
import com.leodev.rooms.model.RoomsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leodev.rooms.model.Room;
import com.leodev.rooms.services.IRoomService;

@RestController
public class RoomController {

	@Autowired
	private IRoomService service;

	@Autowired
	private RoomsConfiguration roomsConfiguration;
	
	@GetMapping("rooms")
	public List<Room> search(){
		return (List<Room>) this.service.search();	
	}

	@GetMapping("/rooms/read/properties")
	public String getProperties() throws JsonProcessingException {
		ObjectWriter owj = new ObjectMapper().writer().withDefaultPrettyPrinter();
		RoomsProperties roomsProperties = new RoomsProperties();
		roomsProperties.setMsg(roomsConfiguration.getMsg());
		roomsProperties.setBuildVersion(roomsConfiguration.getBuildVersion());
		roomsProperties.setMailDetails(roomsConfiguration.getMailDetails());
		return owj.writeValueAsString(roomsProperties);
	}
}
