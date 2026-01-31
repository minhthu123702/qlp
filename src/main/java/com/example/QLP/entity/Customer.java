package com.example.QLP.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer customerId;

    @Column(name = "username", nullable = false, length = 100)
    private String username;

    @Column(name = "phone", length = 15)
    private String phone;

    @Column(name = "address", length = 255)
    private String address;

    @Column(name = "cccd", length = 20, unique = true)
    private String cccd;

    @Column(name = "date")
    private LocalDate date;

    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
//    @JsonManagedReference
//    private List<Booking> bookings;


    public Integer getCustomerId() {
        return customerId;
    }

    public String getUsername() {
        return username;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public String getCccd() {
        return cccd;
    }

    public LocalDate getDate() {
        return date;
    }

//    public List<Booking> getBookings() {
//        return bookings;
//    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

//    public void setBookings(List<Booking> bookings) {
//        this.bookings = bookings;
//    }
}