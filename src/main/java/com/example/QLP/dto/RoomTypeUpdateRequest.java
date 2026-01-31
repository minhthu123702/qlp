package com.example.QLP.dto;

public class RoomTypeUpdateRequest {
    private String nameType;
    private String description;
    private Integer amount;

    public String getNameType() {
        return nameType;
    }

    public String getDescription() {
        return description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
