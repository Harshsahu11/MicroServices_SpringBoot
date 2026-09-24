package com.detrox.inventory_service.serviceImpl;

import com.detrox.inventory_service.repository.InventoryRepository;
import com.detrox.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    @Override
    @Transactional(readOnly = true)
    public boolean inStock(String skuCode) {
        return inventoryRepository.findBySkuCode().isPresent();
    }
}
