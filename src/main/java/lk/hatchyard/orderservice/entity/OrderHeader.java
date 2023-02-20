package lk.hatchyard.orderservice.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderHeader {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;
    private Long customerId;
    private LocalDateTime oderOrderedDate;
    private String oderStatus;

    @JsonManagedReference
    @OneToMany(mappedBy="orderId", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;
}
