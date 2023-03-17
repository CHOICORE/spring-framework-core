package me.choicore.study.springframework.core.order.repository.impl;

import me.choicore.study.springframework.core.order.entity.Order;
import me.choicore.study.springframework.core.order.repository.OrderRepository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryOrderRepository implements OrderRepository {

    private static Map<Long, Order> store = new ConcurrentHashMap<>();

    @Override
    public void save(final Order order) {
        store.put(order.getOrderId(), order);
    }

    @Override
    public Order findById(final Long orderId) {
        return store.get(orderId);
    }

}
