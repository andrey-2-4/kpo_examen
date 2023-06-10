package com.kpoexamen.crudapp.controllers;

import com.kpoexamen.crudapp.models.Booking;
import com.kpoexamen.crudapp.models.Hotel;
import com.kpoexamen.crudapp.repositories.BookingRepository;
import com.kpoexamen.crudapp.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping("/bookings")
    public ResponseEntity<Booking> addHotel(@RequestBody Booking booking) {
        // проерка что отель вообще есть
        if (hotelRepository.findById(booking.getHotelId()).isPresent()) {
            Booking bookingObj = bookingRepository.save(booking);
            return new ResponseEntity<>(bookingObj, HttpStatus.OK);
        }
        // это плохой запрос же, да?
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
