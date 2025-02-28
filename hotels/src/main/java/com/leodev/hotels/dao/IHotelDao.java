package com.leodev.hotels.dao;

import org.springframework.data.repository.CrudRepository;

import com.leodev.hotels.model.Hotel;

public interface IHotelDao extends CrudRepository<Hotel, Long> {

}
