package com.leodev.hotels.services.clients;

import com.leodev.hotels.model.Room;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

// nombre del aplicativo destino (spring.application.name)
@FeignClient("rooms")
public interface IRoomsFeignClient {

    @GetMapping(value = "rooms/{hotelId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<Room> searchByHotelId(@PathVariable long hotelId);
}
