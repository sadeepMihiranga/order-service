package lk.hatchyard.orderservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

    private Long customerId;
    private String customerCode;
    private String customerEmail;
    private String customerContactNo;
    private String customerName;
    private String customerAddress;
}
