package com.leodev.hotels.services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.leodev.hotels.model.HotelRooms;
import com.leodev.hotels.model.Room;
import com.leodev.hotels.services.clients.IRoomsFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leodev.hotels.dao.IHotelDao;
import com.leodev.hotels.model.Hotel;
import org.springframework.web.client.RestTemplate;

@Service
public class HotelServiceImpl implements IHotelService {
	
	@Autowired
	private IHotelDao hotelDao;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private IRoomsFeignClient roomsFeignClient;

	@Override
	public List<Hotel> search() {
		return (List<Hotel>) hotelDao.findAll();
	}

	@Override
	public HotelRooms searchHotelById(long hotelId) {
		HotelRooms response = new HotelRooms();
		Optional<Hotel> hotel = hotelDao.findById(hotelId);
		if (hotel.isPresent()) {

			Map<String, Long> pathVariable = new HashMap<>();
			pathVariable.put("hotelId", hotelId);
			List<Room> rooms = Arrays.asList(restTemplate.getForObject("http:localhost:8081/", Room[].class, pathVariable));
			response.setHotelAddress(hotel.get().getHotelAddress());
			response.setHotelName(hotel.get().getHotelName());
			response.setHotelId(hotel.get().getHotelId());
			response.setRooms(rooms);
		}
		return response;
	}

	@Override
	public HotelRooms searchHotelByIdWithFeign(long hotelId) {
		HotelRooms response = new HotelRooms();
		Optional<Hotel> hotel = hotelDao.findById(hotelId);
		if (hotel.isPresent()) {
			List<Room> rooms = roomsFeignClient.searchByHotelId(hotelId);
			response.setHotelAddress(hotel.get().getHotelAddress());
			response.setHotelName(hotel.get().getHotelName());
			response.setHotelId(hotel.get().getHotelId());
			response.setRooms(rooms);
		}
		return response;
	}
}
