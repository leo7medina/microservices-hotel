package com.leodev.reservations.dao;

import org.springframework.data.repository.CrudRepository;

import com.leodev.reservations.model.Reservation;

public interface IReservationDao extends CrudRepository<Reservation, Long>{

}
