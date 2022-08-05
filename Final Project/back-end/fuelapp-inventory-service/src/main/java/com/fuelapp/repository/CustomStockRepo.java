package com.fuelapp.repository;

import com.fuelapp.models.Order;
import com.fuelapp.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomStockRepo extends JpaRepository<Stock, Long> {
    // CUSTOM METHOD FOR GET STOCK DETAILS BY STATION ID & FUEL TYPE
    @Query(value = "SELECT * FROM stock WHERE station_id = :station_id AND fueltype = :fueltype", nativeQuery = true)
    Stock findByStationId(@Param("station_id") int stationId, @Param("fueltype") String type);
}
