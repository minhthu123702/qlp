package com.example.QLP.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private Integer bookingID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToOne(
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "detail_id", unique = true)
    private BookingDetail detail;

    @Column(name = "invoice_date")
    private LocalDate invoiceDate;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "number_of_guests")
    private int numberOfGuests;

    @Column(name = "note", length = 255)
    private String note;

    public Integer getBookingID() {
        return bookingID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public BookingDetail getDetail() {
        return detail;
    }

    public LocalDate getInvoiceDate() {
        return invoiceDate;
    }

    public String getStatus() {
        return status;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public String getNote() {
        return note;
    }

    public void setId(Integer id) {
        this.bookingID = id;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setDetail(BookingDetail detail) {
        this.detail = detail;
    }

    public void setInvoiceDate(LocalDate invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setNote(String note) {
        this.note = note;
    }
}