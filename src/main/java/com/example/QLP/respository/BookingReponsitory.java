package com.example.QLP.respository;

import com.example.QLP.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingReponsitory extends JpaRepository<Booking,Integer> {
}
