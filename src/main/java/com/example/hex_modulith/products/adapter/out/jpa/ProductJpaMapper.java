package com.example.hex_modulith.products.adapter.out.jpa;

import java.util.Optional;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import com.example.hex_modulith.products.domain.Product;
import com.example.hex_modulith.products.domain.valueobject.ProductPrice;
import com.example.hex_modulith.products.domain.valueobject.ProductSku;

@Mapper(componentModel = "spring")
public interface ProductJpaMapper {
    @Mapping(source = ".", target = "price", qualifiedByName = "mapPrice")
    Product jpaToDomain(ProductJpaEntity productEntity);

    default ProductSku stringToSku(String sku) {
        return Optional.ofNullable(sku).map(ProductSku::new).orElse(null);
    }

    @Named("mapPrice")
    default ProductPrice mapPrice(ProductJpaEntity productJpaEntity) {
        return Optional.ofNullable(productJpaEntity)
            .map(p -> new ProductPrice(p.getPrice(), p.getCurrency()))
            .orElse(null);
    }
}
