package com.detrox.Order_service.service;

import com.detrox.Order_service.dto.OrderRequest;

public interface OrderService {

    public void placeOrder(OrderRequest orderRequest);
}
