package com.das.cartservice.repository;


import com.das.cartservice.model.EbayOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<EbayOrder, Integer> {
    List<EbayOrder> findAllByUserId(int userId);
}
