package com.leodev.rooms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leodev.rooms.model.Room;
import com.leodev.rooms.services.IRoomService;

@RestController
public class RoomController {

	@Autowired
	private IRoomService service;
	
	@GetMapping("rooms")
	public List<Room> search(){
		return (List<Room>) this.service.search();	
	}
}
