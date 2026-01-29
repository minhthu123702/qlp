package com.example.QLP.controller;

import com.example.QLP.dto.CustomerCreateRequest;
import com.example.QLP.dto.CustomerUpdateRequest;
import com.example.QLP.entity.Customer;
import com.example.QLP.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")

public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @PostMapping
    Customer createCustomer(@RequestBody CustomerCreateRequest request){
        return customerService.createRequest(request);
    }
    @GetMapping
    List<Customer> getCustumer(){
        return customerService.getCustomers();
    }
    @GetMapping("/{customerID}")
    public Customer getCustomer(@PathVariable Integer customerID){
        return customerService.getCustomerById(customerID);
    }
    @PutMapping("/{customerID}")
    public Customer updateCustomer(@PathVariable Integer customerID,
                                   @RequestBody CustomerUpdateRequest request){
        return customerService.updateCustomer(customerID, request);
    }

    @DeleteMapping("/{customerID}")
    public String deleteCustomer(@PathVariable Integer customerID) {
        customerService.deleteCustomer(customerID);
        return "Delete success";
    }
}
