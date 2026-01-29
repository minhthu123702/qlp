package com.example.QLP.respository;

import com.example.QLP.entity.Booking;
import com.example.QLP.entity.BookingDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingDetailRepository extends JpaRepository<BookingDetail,Integer> {
}
