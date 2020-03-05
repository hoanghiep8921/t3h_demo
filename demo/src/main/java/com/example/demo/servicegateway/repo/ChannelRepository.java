package com.example.demo.servicegateway.repo;

import com.example.demo.servicegateway.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel,Integer> {
}
