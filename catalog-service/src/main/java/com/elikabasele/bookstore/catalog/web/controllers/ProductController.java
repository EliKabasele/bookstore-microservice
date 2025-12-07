package com.elikabasele.bookstore.catalog.web.controllers;

import com.elikabasele.bookstore.catalog.domain.PageResult;
import com.elikabasele.bookstore.catalog.domain.Product;
import com.elikabasele.bookstore.catalog.domain.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
class ProductController {

    private final ProductService service;

    @GetMapping
    PageResult<Product> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageNo) {
        return service.getProducts(pageNo);
    }
}
