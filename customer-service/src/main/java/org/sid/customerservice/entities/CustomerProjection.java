package org.sid.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;
@Projection(name= "FullCustomer",types= Customer.class)
public interface CustomerProjection {
    public Long getId();
    public String getName();

}
