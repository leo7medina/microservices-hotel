package com.leodev.rooms.dao;

import org.springframework.data.repository.CrudRepository;

import com.leodev.rooms.model.Room;

public interface IRoomDao extends CrudRepository<Room, Long>{

}
