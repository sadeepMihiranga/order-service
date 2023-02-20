package lk.hatchyard.orderservice.service;

import lk.hatchyard.orderservice.dto.CustomerDTO;
import lk.hatchyard.orderservice.dto.CustomerOrderDTO;
import lk.hatchyard.orderservice.dto.OrderDetailDTO;
import lk.hatchyard.orderservice.dto.ProductDTO;
import lk.hatchyard.orderservice.entity.OrderDetail;
import lk.hatchyard.orderservice.entity.OrderHeader;
import lk.hatchyard.orderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    public OrderServiceImpl(OrderRepository orderRepository,
                            RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public OrderHeader saveOrder(OrderHeader order) {

        order.getOrderDetails().forEach(orderDetail -> {
            orderDetail.setOrderId(order);
        });

        order.setOderOrderedDate(LocalDateTime.now());
        order.setOderStatus("A");

        return orderRepository.save(order);
    }

    @Override
    public OrderHeader getOrderByOrderId(Long orderId) {

        return orderRepository.findByOrderId(orderId);
    }

    @Override
    public CustomerOrderDTO getAllOrderInfoByOrderId(Long orderId) {

        OrderHeader orderHeader = orderRepository.findByOrderId(orderId);

        CustomerDTO customer = restTemplate.getForObject(
                "http://CUSTOMER-SERVICE/customers/{id}", CustomerDTO.class, orderHeader.getCustomerId());

        List<OrderDetailDTO> items = new ArrayList<>();

        for(OrderDetail orderDetail : orderHeader.getOrderDetails()) {

            ProductDTO productDTO = restTemplate.getForObject(
                    "http://PRODUCT-SERVICE/products/{id}", ProductDTO.class, orderDetail.getProductId());

            OrderDetailDTO orderItem = OrderDetailDTO.builder()
                            .orderDetailId(orderDetail.getOrderDetailId())
                            .product(productDTO)
                            .quantity(orderDetail.getQuantity())
                            .unitAmount(orderDetail.getUnitAmount())
                            .totalAmount(orderDetail.getTotalAmount())
                            .build();

            items.add(orderItem);
        }

        return CustomerOrderDTO.builder()
                .orderId(orderHeader.getOrderId())
                .oderOrderedDate(orderHeader.getOderOrderedDate())
                .oderStatus(orderHeader.getOderStatus())
                .customer(customer)
                .items(items)
                .build();
    }
}
