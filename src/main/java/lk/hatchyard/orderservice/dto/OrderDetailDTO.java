package lk.hatchyard.orderservice.dto;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class OrderDetailDTO {

    private Long orderDetailId;
    private ProductDTO product;
    private Long quantity;
    private BigDecimal unitAmount;
    private BigDecimal totalAmount;
}
