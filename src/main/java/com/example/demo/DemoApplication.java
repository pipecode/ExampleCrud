package com.example.demo;

import com.example.demo.model.Coupon;
import com.example.demo.model.User;
import com.example.demo.repository.CouponRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.UUID;

@SpringBootApplication
@EnableJpaRepositories("com.example.demo.repository")
@EntityScan("com.example.demo.model")
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private CouponRepository couponRepository;

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Coupon coupon = new Coupon();
        coupon.setCode(UUID.randomUUID().toString());
        coupon.setDescription("Oferta del mes");
        coupon.setCreatedAt(new Date());
        coupon.setExpiredAt(Date.from(LocalDate.now().plusDays(30).atStartOfDay(ZoneId.systemDefault()).toInstant()));

        couponRepository.save(coupon);

        User user = new User();
        user.setDocumentType("CC");
        user.setDocument("1115084843");
        user.setFullName("LUIS FELIPE CASTRO");
        userRepository.save(user);
    }
}
