package com.example.QLP.service;

import com.example.QLP.dto.RoomCreateRequest;
import com.example.QLP.entity.Room;
import com.example.QLP.entity.RoomType;
import com.example.QLP.respository.RoomReponsitory;
import com.example.QLP.respository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomReponsitory roomReponsitory;

    @Autowired
    private RoomTypeRepository roomTypeRepository;


    public Room createRoom(RoomCreateRequest request) {

        RoomType type = roomTypeRepository.findById(request.getRoomTypeId())
                .orElseThrow(() -> new RuntimeException("Room type not found"));

        Room room = new Room();
        room.setType(type);
        room.setRoomNumber(request.getRoomNumber());
        room.setDescription(request.getDescription());

        return roomReponsitory.save(room);
    }


    public List<Room> getAllRooms() {
        return roomReponsitory.findAll();
    }


    public Room getRoomById(Integer id) {
        return roomReponsitory.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));
    }


    public Room updateRoom(Integer id, RoomCreateRequest request) {

        Room room = roomReponsitory.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        RoomType type = roomTypeRepository.findById(request.getRoomTypeId())
                .orElseThrow(() -> new RuntimeException("Room type not found"));

        room.setType(type);
        room.setRoomNumber(request.getRoomNumber());
        room.setDescription(request.getDescription());

        return roomReponsitory.save(room);
    }

    public void deleteRoom(Integer id) {

        Room room = roomReponsitory.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found"));

        roomReponsitory.delete(room);
    }
}
