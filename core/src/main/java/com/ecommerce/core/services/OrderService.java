package com.ecommerce.core.services;
import com.ecommerce.core.models.*;
import com.ecommerce.core.repositories.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@Service
public class OrderService {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate = new RestTemplate();

    public OrderService(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order processCheckout(Long productId, Integer quantity, Long userId) {
        Product product = productRepository.findByIdForUpdate(productId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (product.getStock() < quantity) {
            throw new RuntimeException("Estoque insuficiente!");
        }

        product.setStock(product.getStock() - quantity);
        productRepository.save(product);

        Order order = new Order(userId, product, quantity);
        orderRepository.save(order);

        CompletableFuture.runAsync(() -> sendNotificationToNodeJS(order));
        return order;
    }

    private void sendNotificationToNodeJS(Order order) {
        String nodeJsUrl = "http://localhost:3000/notify";
        Map<String, Object> payload = new HashMap<>();
        payload.put("orderId", order.getId());
        payload.put("userId", order.getUserId());
        payload.put("status", "CONFIRMED");
        try { restTemplate.postForEntity(nodeJsUrl, payload, String.class); } 
        catch (Exception e) { System.err.println("Erro no envio da notificação."); }
    }
}