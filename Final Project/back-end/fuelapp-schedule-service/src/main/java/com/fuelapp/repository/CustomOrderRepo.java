package com.fuelapp.repository;

import com.fuelapp.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomOrderRepo extends JpaRepository<Order, Long> {
    // CUSTOM METHOD FOR GET ORDER DETAILS BY ORDER ID
    @Query(value = "SELECT * FROM order1 WHERE order_id = ?1", nativeQuery = true)
    Order findByOrderId(int orderId);
}
