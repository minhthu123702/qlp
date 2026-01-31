package com.example.QLP.service;

import com.example.QLP.dto.BookingCreateRequest;
import com.example.QLP.dto.BookingDetailCreateRequest;
import com.example.QLP.entity.Booking;
import com.example.QLP.entity.BookingDetail;
import com.example.QLP.entity.Room;
import com.example.QLP.respository.BookingDetailRepository;
import com.example.QLP.respository.BookingReponsitory;
import com.example.QLP.respository.RoomReponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingDetailService {

    @Autowired
    private BookingDetailRepository bookingDetailRepository;

    @Autowired
    private BookingReponsitory bookingReponsitory;

    @Autowired
    private RoomReponsitory roomReponsitory;


    public BookingDetail createRequest(BookingDetailCreateRequest request) {
        BookingDetail bookingDetail = new BookingDetail();

        if (request.getBookingId() != null) {
            Booking booking = bookingReponsitory.findById(request.getBookingId())
                    .orElseThrow(() -> new RuntimeException("Booking not found"));
            bookingDetail.setBooking(booking);
        }

        Room room = roomReponsitory.findById(request.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        bookingDetail.setRoom(room);
        bookingDetail.setCheckInDate(request.getCheckInDate());
        bookingDetail.setCheckOutDate(request.getCheckOutDate());
        bookingDetail.setPrice(request.getPrice());
        bookingDetail.setQuantity(request.getQuantity());
        bookingDetail.setTotalAmount(request.getTotalAmount());
        return bookingDetailRepository.save(bookingDetail);
    }
    public List<BookingDetail> getAll(){
        return bookingDetailRepository.findAll();
    }


    public BookingDetail getById(Integer id){
        return bookingDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BookingDetail not found"));
    }


    public BookingDetail update(Integer id, BookingDetailCreateRequest request){

        BookingDetail detail = bookingDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BookingDetail not found"));

        if (request.getBookingId() != null) {
            Booking booking = bookingReponsitory.findById(request.getBookingId())
                    .orElseThrow(() -> new RuntimeException("Booking not found"));
            detail.setBooking(booking);
        }

        Room room = roomReponsitory.findById(request.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found"));

        detail.setRoom(room);
        detail.setCheckInDate(request.getCheckInDate());
        detail.setCheckOutDate(request.getCheckOutDate());
        detail.setPrice(request.getPrice());
        detail.setQuantity(request.getQuantity());
        detail.setTotalAmount(request.getTotalAmount());

        return bookingDetailRepository.save(detail);
    }


    public void delete(Integer id){
        BookingDetail detail = bookingDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BookingDetail not found"));

        bookingDetailRepository.delete(detail);
    }
}
