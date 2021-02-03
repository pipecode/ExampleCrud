package com.example.demo.service;

import com.example.demo.dto.CreateCouponRequest;
import com.example.demo.model.Coupon;
import com.example.demo.model.User;
import com.example.demo.repository.CouponRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponService {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Coupon> findAll() {
        return (List<Coupon>) couponRepository.findAll();
    }

    public Coupon findByCode(String code) throws Exception {
        Coupon current = couponRepository.findByCode(code);
        if (current != null) {
            return current;
        } else {
            throw new Exception("Coupon with code: " + code + " doesn`t exist");
        }
    }

    public Coupon createCoupon(CreateCouponRequest request) throws Exception {
        Coupon current = couponRepository.findByCode(request.getCode());
        if (current == null) {
            Coupon newCoupon = new Coupon();
            newCoupon.setCode(request.getCode());
            newCoupon.setDescription(request.getDescription());
            if (request.getDocumentType() != null && !request.getDocumentType().equals("") && request.getDocument() != null && !request.getDocument().equals("")) {
                User user = userRepository.findByDocumentTypeAndDocument(request.getDocumentType(), request.getDocument());
                if (user != null) {
                    newCoupon.setUser(user);
                } else {
                    throw new Exception("User with type and document: " + request.getDocumentType() + "-" + request.getDocument() + " doesn`t exist");
                }
            }
            return couponRepository.save(newCoupon);
        } else {
            throw new Exception("Coupon with code: " + request.getCode() + " already exist");
        }

    }

    public Coupon updateCoupon(Coupon coupon) throws Exception {
        Coupon current = couponRepository.findByCode(coupon.getCode());
        if (current != null) {
            current.setCode(coupon.getCode());
            current.setDescription(coupon.getDescription());
            return current;
        } else {
            throw new Exception("Coupon with code: " + coupon.getCode() + " doesn`t exist");
        }
    }
}
