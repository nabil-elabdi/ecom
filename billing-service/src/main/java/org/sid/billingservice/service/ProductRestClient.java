package org.sid.billingservice.service;

import org.sid.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.web.config.SpringDataJacksonConfiguration;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVENTORY.SERVICE")
public interface ProductRestClient
{
    @GetMapping(path = "/products/{id}")
    Product findProductById(@PathVariable Long id);
    @GetMapping("/products")
    PagedModel<Product> allProducts();
}
