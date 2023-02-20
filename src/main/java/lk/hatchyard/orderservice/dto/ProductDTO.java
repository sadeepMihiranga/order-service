package lk.hatchyard.orderservice.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProductDTO {

    private Long productId;
    private String productCode;
    private String productName;
    private String productCategory;
}
