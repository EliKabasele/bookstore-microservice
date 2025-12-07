package com.elikabasele.bookstore.catalog.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;
    private final ProductMapper mapper;

    @Value("${catalog.page-size}")
    private int pageSize;

    public PageResult<Product> getProducts(int pageNo) {

        Sort sort = Sort.by("name");
        pageNo = pageNo <= 1 ? 0 : pageNo - 1;
        PageRequest pageRequest = PageRequest.of(pageNo, pageSize, sort);

        Page<Product> productPage = repository.findAll(pageRequest).map(mapper::toProduct);

        return new PageResult<>(
                productPage.getContent(),
                productPage.getTotalElements(),
                productPage.getNumber() + 1,
                productPage.getTotalPages(),
                productPage.isFirst(),
                productPage.isLast(),
                productPage.hasNext(),
                productPage.hasPrevious());
    }
}
