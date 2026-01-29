package com.example.QLP.service;

import com.example.QLP.dto.BookingCreateRequest;
import com.example.QLP.entity.Booking;
import com.example.QLP.entity.BookingDetail;
import com.example.QLP.entity.Customer;
import com.example.QLP.respository.BookingDetailRepository;
import com.example.QLP.respository.BookingReponsitory;
import com.example.QLP.respository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookingService {

    @Autowired
    private BookingReponsitory bookingReponsitory;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookingDetailRepository bookingDetailRepository;


    public Booking createRequest(BookingCreateRequest request) {

        Booking booking = new Booking();

        Customer customer = customerRepository.findById(request.getCustomerId())
                .orElseThrow(() -> new RuntimeException("Customer not found"));

        BookingDetail detail = bookingDetailRepository.findById(request.getDetailId())
                .orElseThrow(() -> new RuntimeException("Detail not found"));

        booking.setCustomer(customer);
        booking.setDetail(detail);
        booking.setInvoiceDate(request.getInvoiceDate());
        booking.setNote(request.getNote());
        booking.setNumberOfGuests(request.getNumberOfGuests());
        booking.setStatus(request.getStatus());

        return bookingReponsitory.save(booking);
    }
    public List<Booking> getBookings() {
        return bookingReponsitory.findAll();
    }


    public Booking getBookingById(Integer id) {
        return bookingReponsitory.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found"));
    }


    public void deleteBooking(Integer id) {
        if (!bookingReponsitory.existsById(id)) {
            throw new RuntimeException("Booking not found");
        }
        bookingReponsitory.deleteById(id);
    }
}