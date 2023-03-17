package me.choicore.study.springframework.core.order.service;

import me.choicore.study.springframework.core.order.entity.Order;

public interface OrderService {

    Order createOrder(Long memberId, String itemName, int itemPrice);


}
