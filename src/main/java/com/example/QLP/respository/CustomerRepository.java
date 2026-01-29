package com.example.QLP.respository;

import com.example.QLP.entity.Booking;
import com.example.QLP.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {


}
