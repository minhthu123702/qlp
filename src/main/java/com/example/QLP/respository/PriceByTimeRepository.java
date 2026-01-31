package com.example.QLP.respository;

import com.example.QLP.entity.PriceByTime;
import com.example.QLP.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PriceByTimeRepository extends JpaRepository<PriceByTime,Integer> {
}
