package org.sid.billingservice.repository;

import org.sid.billingservice.entities.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductItem,Long>
{

}
