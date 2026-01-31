package com.example.QLP.controller;

import com.example.QLP.dto.BookingDetailCreateRequest;
import com.example.QLP.entity.BookingDetail;
import com.example.QLP.service.BookingDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookingDetails")
public class BookingDetailController {

    @Autowired
    private BookingDetailService bookingDetailService;


    @PostMapping
    public BookingDetail createBookingDetail(@RequestBody BookingDetailCreateRequest request) {
        return bookingDetailService.createRequest(request);
    }


    @GetMapping
    public List<BookingDetail> getAllBookingDetails() {
        return bookingDetailService.getAll();
    }


    @GetMapping("/{id}")
    public BookingDetail getBookingDetailById(@PathVariable Integer id) {
        return bookingDetailService.getById(id);
    }


    @PutMapping("/{id}")
    public BookingDetail updateBookingDetail(
            @PathVariable Integer id,
            @RequestBody BookingDetailCreateRequest request) {

        return bookingDetailService.update(id, request);
    }


    @DeleteMapping("/{id}")
    public void deleteBookingDetail(@PathVariable Integer id) {
        bookingDetailService.delete(id);
    }
}
