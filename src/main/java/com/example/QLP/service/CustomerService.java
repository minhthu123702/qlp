package com.example.QLP.service;

import com.example.QLP.dto.CustomerCreateRequest;
import com.example.QLP.dto.CustomerUpdateRequest;
import com.example.QLP.entity.Customer;
import com.example.QLP.respository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    // CREATE
    public Customer createRequest(CustomerCreateRequest request) {
        Customer customer = new Customer();

        customer.setUsername(request.getUsername());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());
        customer.setCccd(request.getCccd());
        customer.setDate(request.getDate());

        return customerRepository.save(customer);
    }

    // READ ALL
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }


    public Customer getCustomerById(Integer id){
        return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }
    public Customer updateCustomer(Integer customerID, CustomerUpdateRequest request) {

        Customer customer = getCustomerById(customerID);

        customer.setUsername(request.getUsername());
        customer.setPhone(request.getPhone());
        customer.setAddress(request.getAddress());
        customer.setCccd(request.getCccd());
        customer.setDate(request.getDate());

        return customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id) {
        if (!customerRepository.existsById(id)) {
            throw new RuntimeException("Customer not found");
        }
        customerRepository.deleteById(id);
    }
}