package com.example.demo.controller;

import com.example.demo.dto.CreateCouponRequest;
import com.example.demo.model.Coupon;
import com.example.demo.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupon")
public class CouponRestController {

    @Autowired
    private CouponService couponService;

    @GetMapping
    public List<Coupon> findAll() {
        return couponService.findAll();
    }

    @GetMapping("/{code}/{var}/{var3}")
    public Coupon findByCode(@PathVariable("code") String code, @PathVariable("var2") String var2, @PathVariable("var3") String var3) throws Exception {
        return couponService.findByCode(code);
    }

    @GetMapping("/param")
    public Coupon findByCodeParam(@RequestParam("code") String code) throws Exception {
        return couponService.findByCode(code);
    }

    @PostMapping
    public Coupon create(@RequestBody CreateCouponRequest request) throws Exception {
        return couponService.createCoupon(request);
    }

    @PutMapping
    public Coupon update(@RequestBody Coupon coupon) throws Exception {
        return couponService.updateCoupon(coupon);
    }
}
