package com.leodev.rooms.dao;

import org.springframework.data.repository.CrudRepository;

import com.leodev.rooms.model.Room;

import java.util.List;

public interface IRoomDao extends CrudRepository<Room, Long>{

    List<Room> findByHotelId(long hotelId);
}
