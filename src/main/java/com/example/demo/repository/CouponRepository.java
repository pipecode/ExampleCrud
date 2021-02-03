package com.example.demo.repository;

import com.example.demo.model.Coupon;
import org.springframework.data.repository.CrudRepository;

public interface CouponRepository extends CrudRepository<Coupon, Long> {

    Coupon findByCode(String code);
}
