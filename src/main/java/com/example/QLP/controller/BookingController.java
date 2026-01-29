package com.example.QLP.controller;

import com.example.QLP.dto.BookingCreateRequest;
import com.example.QLP.entity.Booking;
import com.example.QLP.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;


    @PostMapping
    public Booking createBooking(@RequestBody BookingCreateRequest request){
        return bookingService.createRequest(request);
    }


    @GetMapping
    public List<Booking> getBookings(){
        return bookingService.getBookings();
    }

    @GetMapping("/{Bookingid}")
    public Booking getBookingById(@PathVariable Integer Bookingid){
        return bookingService.getBookingById(Bookingid);
    }

    @DeleteMapping("/{Bookingid}")
    public void deleteBooking(@PathVariable Integer Bookingid){
        bookingService.deleteBooking(Bookingid);
    }
}