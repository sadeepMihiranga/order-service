package lk.hatchyard.orderservice.controller;

import lk.hatchyard.orderservice.dto.CustomerOrderDTO;
import lk.hatchyard.orderservice.entity.OrderHeader;
import lk.hatchyard.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@Slf4j
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public OrderHeader saveOrder(@RequestBody OrderHeader order) {
        log.info("saveOrder method invoked");
        return orderService.saveOrder(order);
    }

    @GetMapping("/{id}")
    public CustomerOrderDTO findOrderByOrderId(@PathVariable("id") Long orderId) {
        log.info("findOrderByOrderId method invoked");
        return orderService.getAllOrderInfoByOrderId(orderId);
    }
}
