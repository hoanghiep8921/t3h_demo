package com.example.microservices.repository;


import com.example.microservices.model.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ExchangeValueRepository extends
        JpaRepository<ExchangeValue, Long>{
    ExchangeValue findByFromAndTo(String from, String to);
}