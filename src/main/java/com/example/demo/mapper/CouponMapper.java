package com.example.demo.mapper;

import com.example.demo.dto.CreateCouponRequest;
import com.example.demo.model.Coupon;

public class CouponMapper {

    public static Coupon mapToCoupon(CreateCouponRequest request) {
        Coupon coupon = new Coupon();
        coupon.setCode(request.getCode());
        coupon.setDescription(request.getDescription());
        return coupon;
    }
}
