
package com.example.QLP.service;

import com.example.QLP.dto.PriceByTimeCreateRequest;
import com.example.QLP.dto.PriceByTimeUpdateRequest;
import com.example.QLP.entity.PriceByTime;
import com.example.QLP.entity.RoomType;
import com.example.QLP.respository.PriceByTimeRepository;
import com.example.QLP.respository.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceByTimeService {

    @Autowired
    private PriceByTimeRepository priceRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    public PriceByTime create(PriceByTimeCreateRequest request) {

        PriceByTime price = new PriceByTime();

        RoomType roomType = roomTypeRepository.findById(request.getRoomTypeId())
                .orElseThrow(() -> new RuntimeException("RoomType not found"));

        price.setRoomType(roomType);
        price.setFromDate(request.getFromDate());
        price.setToDate(request.getToDate());
        price.setPrice(request.getPrice());

        return priceRepository.save(price);
    }


    public List<PriceByTime> getAll() {
        return priceRepository.findAll();
    }

    public PriceByTime getById(Integer id) {
        return priceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Price not found"));
    }

    public PriceByTime update(Integer id, PriceByTimeUpdateRequest request) {

        PriceByTime price = getById(id);

        RoomType roomType = roomTypeRepository.findById(request.getRoomTypeId())
                .orElseThrow(() -> new RuntimeException("RoomType not found"));

        price.setRoomType(roomType);
        price.setFromDate(request.getFromDate());
        price.setToDate(request.getToDate());
        price.setPrice(request.getPrice());

        return priceRepository.save(price);
    }


    public void delete(Integer id) {
        priceRepository.deleteById(id);
    }
}
