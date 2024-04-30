package com.OMS.OrderManagementSystem;

import model.CurrentStatus;
import model.Order;

public interface OrderService {
    Order omsPrepareOrder(Long orderid);

    Order omsCreateOrder(Order order);

    Order omsUpdateCurrentStatus(Long orderId, CurrentStatus status);
    void omsPostponeorder(Long orderId);
}
