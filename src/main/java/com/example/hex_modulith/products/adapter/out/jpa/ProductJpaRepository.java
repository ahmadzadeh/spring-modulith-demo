package com.example.hex_modulith.products.adapter.out.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductJpaEntity, Long> {
    @Query("""
        select case when p.quantity >= :quantity then true else false end
        from ProductJpaEntity p where p.sku = :sku
        """)
    boolean isAvailable(String sku, int quantity);

    Optional<ProductJpaEntity> findBySku(String sku);
}
