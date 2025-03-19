package com.leodev.rooms.services;

import java.util.List;

import com.leodev.rooms.model.Room;

public interface IRoomService {
	
	List<Room> search();

	List<Room> searchRoomByHotelId(long hotelId);

}
