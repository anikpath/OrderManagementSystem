package com.OMS.OrderManagementSystem;

import model.CurrentStatus;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

public class OrderServcieImpl implements OrderService{

        @Autowired
        private OrderRepository orderRepository;
        private ConcurrentMap<Long, Order> orders = new ConcurrentHashMap<>();
        private AtomicLong orderIdGenerator = new AtomicLong(1);
        @Override
        public Order omsPrepareOrder(Long orderid) {
            return orders.get(orderid);
        }

        @Override
        public  synchronized Order omsCreateOrder(Order order) {
            Long orderId = orderIdGenerator.getAndIncrement();
            order.setId(orderId);
            orders.put(orderId, order);
            return order;
        }

        @Override
        public synchronized Order  omsUpdateCurrentStatus(Long orderId, CurrentStatus status) {
            Order order = orders.get(orderId);
            if (order != null) {
                order.setStatus(status);
                return order;
            }
            return null;
        }


        @Override
        public synchronized  void omsPostponeorder(Long orderId) {
            orders.remove(orderId);
        }
    }


