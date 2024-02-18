package org.sid.billingservice.web;

import org.sid.billingservice.entities.Bill;
import org.sid.billingservice.repository.BillRepository;
import org.sid.billingservice.repository.ProductRepository;
import org.sid.billingservice.service.CustomerRestClient;
import org.sid.billingservice.service.ProductRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillRestController {
    @Autowired //constructor
    private BillRepository billRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRestClient customerRestClient;
    @Autowired
    private ProductRestClient productRestClient;

    @GetMapping("/fullBill/id")
    public Bill bill(@PathVariable Long id){
        Bill bill=billRepository.findById(id).get(); //ou orElse(null);
        bill.setCustomer(customerRestClient.findCustomerById(bill.getCustomerId()));
        bill.getProductItems().forEach(productItem ->{
            productItem.setProductId(productRestClient.findProductById(productItem.getProductId()).getId());
        } );

        return bill;

    }
}
