package com.example.QLP.service;

import com.example.QLP.dto.RoomTypeCreateRequest;
import com.example.QLP.entity.RoomType;
import com.example.QLP.respository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeService {

    @Autowired
    private RoomTypeRepository roomTypeRepository;


    public RoomType createRoomType(RoomTypeCreateRequest request) {

        RoomType roomType = new RoomType();

        roomType.setNameType(request.getNameType());
        roomType.setDescription(request.getDescription());
        roomType.setAmount(request.getAmount());

        return roomTypeRepository.save(roomType);
    }


    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }

    public RoomType getRoomTypeById(Integer id) {
        return roomTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoomType not found"));
    }

    public RoomType updateRoomType(Integer id, RoomTypeCreateRequest request) {

        RoomType roomType = roomTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoomType not found"));

        roomType.setNameType(request.getNameType());
        roomType.setDescription(request.getDescription());
        roomType.setAmount(request.getAmount());

        return roomTypeRepository.save(roomType);
    }


    public void deleteRoomType(Integer id) {

        RoomType roomType = roomTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("RoomType not found"));

        roomTypeRepository.delete(roomType);
    }
}
