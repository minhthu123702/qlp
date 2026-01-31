package com.example.QLP.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class BookingCreateRequest {


    private Integer bookingID;
    private Integer detailId;
    private Integer customerId;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate invoiceDate;

    private String status;
    private int numberOfGuests;
    private String note;

    public Integer getCustomerId() {
        return customerId;
    }

    public Integer getBookingID() {
        return bookingID;
    }

    public Integer getDetailId() {
        return detailId;
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

    public void setBookingID(Integer bookingID) {
        this.bookingID = bookingID;
    }

    public void setDetailId(Integer detailId) {
        this.detailId = detailId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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