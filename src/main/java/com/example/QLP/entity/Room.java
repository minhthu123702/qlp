package com.example.QLP.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer id;

    @OneToMany(
            mappedBy = "room",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<BookingDetail> bookingDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", nullable = false)
    private RoomType type;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "room_number", unique = true, nullable = false, length = 20)
    private String roomNumber;

    public Integer getId() {
        return id;
    }

    public List<BookingDetail> getBookingDetails() {
        return bookingDetails;
    }

    public RoomType getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBookingDetails(List<BookingDetail> bookingDetails) {
        this.bookingDetails = bookingDetails;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}