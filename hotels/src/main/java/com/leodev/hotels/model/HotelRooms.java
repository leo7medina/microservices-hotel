package com.leodev.hotels.model;

import lombok.Data;

import java.util.List;

@Data
public class HotelRooms {
    private long hotelId;
    private String hotelName;
    private String hotelAddress;
    private List<Room> rooms;
}
