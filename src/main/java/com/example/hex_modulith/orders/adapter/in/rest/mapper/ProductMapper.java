package com.example.hex_modulith.orders.adapter.in.rest.mapper;

import org.mapstruct.Mapper;

import com.example.hex_modulith.orders.adapter.in.rest.dto.ProductDTO;
import com.example.hex_modulith.orders.domain.Product;


@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toProductDTO(Product product);
}
