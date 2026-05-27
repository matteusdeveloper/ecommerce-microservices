package com.ecommerce.core.controllers;
import com.ecommerce.core.models.Order;
import com.ecommerce.core.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    public OrderController(OrderService orderService) { this.orderService = orderService; }

    @PostMapping("/checkout")
    public ResponseEntity<?> checkout(@RequestParam Long productId, @RequestParam Integer quantity, @RequestParam Long userId) {
        try {
            Order order = orderService.processCheckout(productId, quantity, userId);
            return ResponseEntity.ok("Pedido " + order.getId() + " processado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}