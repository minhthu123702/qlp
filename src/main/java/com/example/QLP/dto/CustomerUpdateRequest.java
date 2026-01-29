package com.example.QLP.dto;

import java.time.LocalDate;

public class CustomerUpdateRequest {
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
    private String username;
    private String phone;
    private String address;
    private String cccd;
    private LocalDate date;
    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getCccd() {
        return cccd;
    }

    public String getUsername() {
        return username;
    }

    public LocalDate getDate() {
        return date;
    }
}
