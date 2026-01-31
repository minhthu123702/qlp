package com.example.QLP.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Integer roomId;

    @OneToMany(mappedBy = "room",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    @JsonIgnore
    private List<BookingDetail> bookingDetails;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id", nullable = false)
    @JsonIgnore
    private RoomType type;

    // ✅ chỉ trả ID
    public Integer getRoomTypeId() {
        return type != null ? type.getId() : null;
    }

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "room_number", unique = true, nullable = false, length = 20)
    private String roomNumber;

    // ===== getter setter =====

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }
}
