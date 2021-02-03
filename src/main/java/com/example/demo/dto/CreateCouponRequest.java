package com.example.demo.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@Data
public class CreateCouponRequest {

    private String code;
    private String description;
    private String documentType;
    private String document;
    private Date expiredAt = Date.from(LocalDate.now().plusDays(30).atStartOfDay(ZoneId.systemDefault()).toInstant());
    private Date createdAt = new Date();
}
