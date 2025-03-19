package com.leodev.hotels.services;

import java.util.List;

import com.leodev.hotels.model.Hotel;
import com.leodev.hotels.model.HotelRooms;

public interface IHotelService {
	
	List<Hotel> search();

	HotelRooms searchHotelById(long hotelId);

	HotelRooms searchHotelByIdWithFeign(long hotelId);
	

}
