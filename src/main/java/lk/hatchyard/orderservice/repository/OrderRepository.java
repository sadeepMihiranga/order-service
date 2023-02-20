package lk.hatchyard.orderservice.repository;

import lk.hatchyard.orderservice.entity.OrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<OrderHeader, Long> {

    OrderHeader findByOrderId(Long orderId);
}
