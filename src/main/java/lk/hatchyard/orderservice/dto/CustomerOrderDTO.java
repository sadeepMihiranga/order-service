package lk.hatchyard.orderservice.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomerOrderDTO {

    private Long orderId;
    private LocalDateTime oderOrderedDate;
    private String oderStatus;
    private CustomerDTO customer;
    private List<OrderDetailDTO> items;
}
