package com.lucio.ecommerce.dao;

import com.lucio.ecommerce.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// override default
public interface ProductRepository extends JpaRepository<Product, Long> {
}
