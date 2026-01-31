package com.example.QLP.controller;

import com.example.QLP.dto.RoomTypeCreateRequest;
import com.example.QLP.entity.RoomType;
import com.example.QLP.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/room-types")
public class RoomTypeController {

    @Autowired
    private RoomTypeService service;

    @PostMapping
    public RoomType create(@RequestBody RoomTypeCreateRequest request) {
        return service.createRoomType(request);
    }

    @GetMapping
    public List<RoomType> getAll() {
        return service.getAllRoomTypes();
    }

    @GetMapping("/{id}")
    public RoomType getById(@PathVariable Integer id) {
        return service.getRoomTypeById(id);
    }

    @PutMapping("/{id}")
    public RoomType update(@PathVariable Integer id,
                           @RequestBody RoomTypeCreateRequest request) {
        return service.updateRoomType(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.deleteRoomType(id);
    }
}
