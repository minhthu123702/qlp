package com.example.QLP.controller;


import com.example.QLP.dto.PriceByTimeCreateRequest;
import com.example.QLP.dto.PriceByTimeUpdateRequest;
import com.example.QLP.entity.PriceByTime;
import com.example.QLP.service.PriceByTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
public class PriceByTimeController {

    @Autowired
    private PriceByTimeService service;


    @PostMapping
    public PriceByTime create(@RequestBody PriceByTimeCreateRequest request) {
        return service.create(request);
    }


    @GetMapping
    public List<PriceByTime> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public PriceByTime getById(@PathVariable Integer id) {
        return service.getById(id);
    }


    @PutMapping("/{id}")
    public PriceByTime update(
            @PathVariable Integer id,
            @RequestBody PriceByTimeUpdateRequest request) {
        return service.update(id, request);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
