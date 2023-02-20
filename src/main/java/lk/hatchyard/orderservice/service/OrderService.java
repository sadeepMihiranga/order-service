package lk.hatchyard.orderservice.service;

import lk.hatchyard.orderservice.dto.CustomerOrderDTO;
import lk.hatchyard.orderservice.entity.OrderHeader;

public interface OrderService {

    OrderHeader saveOrder(OrderHeader order);

    OrderHeader getOrderByOrderId(Long orderId);

    CustomerOrderDTO getAllOrderInfoByOrderId(Long orderId);
}
