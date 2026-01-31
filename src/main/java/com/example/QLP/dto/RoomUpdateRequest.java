package com.example.QLP.dto;

public class RoomUpdateRequest {

    private Integer roomTypeId;
    private String roomNumber;
    private String description;

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
