package com.example.QLP.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "room_type")
public class RoomType {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "type_id")
    private Integer id;

    @Column(name = "name_type", nullable = false, length = 100)
    private String nameType;

    @Column(name = "description", length = 255)
    private String description;


    @Column(name = "amount")
    private Integer amount;

    @OneToMany(mappedBy = "type", fetch = FetchType.LAZY)
    private List<Room> rooms;


    public Integer getId() {
        return id;
    }

    public String getNameType() {
        return nameType;
    }

    public String getDescription() {
        return description;
    }

    public Integer getAmount() {
        return amount;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}