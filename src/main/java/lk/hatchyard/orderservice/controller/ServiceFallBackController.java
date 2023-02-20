package lk.hatchyard.orderservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fall-back")
public class ServiceFallBackController {

    @GetMapping("/customer-service")
    public String customerServiceFallBackMethod() {
        return "Customer Service Not Working";
    }

    @GetMapping("/product-service")
    public String productServiceFallBackMethod() {
        return "Product Service Not Working";
    }
}
