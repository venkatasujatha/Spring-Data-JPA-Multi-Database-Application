package com.example.demo.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.model.customer.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
