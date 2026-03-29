package com.libms.order_service.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libms.order_service.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID>{

}
