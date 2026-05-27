package com.ecommerce.core.repositories;

import com.ecommerce.core.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {}