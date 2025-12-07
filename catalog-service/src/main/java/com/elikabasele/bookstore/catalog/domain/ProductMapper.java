package com.elikabasele.bookstore.catalog.domain;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
interface ProductMapper {

    /**
     * Converts a ProductEntity JPA entity to a Product DTO record.
     * The 'id' from the entity is automatically ignored as it does not exist in the DTO record.
     */
    Product toProduct(ProductEntity entity);
}
