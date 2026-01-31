package com.example.QLP.controller;


import com.example.QLP.dto.RoomCreateRequest;
import com.example.QLP.entity.Room;
import com.example.QLP.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @PostMapping
    public Room create(@RequestBody RoomCreateRequest request) {
        return roomService.createRoom(request);
    }

    @GetMapping
    public List<Room> getAll() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Room getById(@PathVariable Integer id) {
        return roomService.getRoomById(id);
    }

    @PutMapping("/{id}")
    public Room update(@PathVariable Integer id,
                       @RequestBody RoomCreateRequest request) {
        return roomService.updateRoom(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        roomService.deleteRoom(id);
    }
}
