package com.libms.inventory_service.repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.libms.inventory_service.model.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, UUID> {

}
