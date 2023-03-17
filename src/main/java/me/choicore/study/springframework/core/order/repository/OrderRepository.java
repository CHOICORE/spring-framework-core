package me.choicore.study.springframework.core.order.repository;

import me.choicore.study.springframework.core.order.entity.Order;

public interface OrderRepository {

    void save(Order order);

    Order findById(Long orderId);
}
