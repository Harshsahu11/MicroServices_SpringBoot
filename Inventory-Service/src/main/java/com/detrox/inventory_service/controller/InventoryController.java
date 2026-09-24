package com.detrox.inventory_service.controller;

import com.detrox.inventory_service.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping("/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean InStock(@PathVariable("sku-code") String skuCode){
        return inventoryService.inStock(skuCode);
    }
}
