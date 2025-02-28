package com.leodev.reservations.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leodev.reservations.dao.IReservationDao;
import com.leodev.reservations.model.Reservation;

@Service
public class ReservationServiceImpl implements IReservationService {

	@Autowired
	private IReservationDao reservationDao;
	
	@Override
	public List<Reservation> search() {
		return (List<Reservation>) reservationDao.findAll();
	}

}
