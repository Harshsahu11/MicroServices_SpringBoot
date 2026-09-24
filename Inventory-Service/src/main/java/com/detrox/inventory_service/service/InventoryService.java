package com.detrox.inventory_service.service;

import com.detrox.inventory_service.dto.InventoryResponse;

import java.util.List;

public interface InventoryService {
    public List<InventoryResponse> isInStock(List<String> skuCode);
}
