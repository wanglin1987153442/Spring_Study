package com.Spring_Study.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wl
 * @ClassNamephone
 * @Description TODO
 * @Date 2020/3/12
 * @Version 1.0
 */
@Data

public class Phone {
    private String phone;
    private double price;

    public Phone(String phone, double price) {
        this.phone = phone;
        this.price = price;
    }

    public Phone(String phone) {
    }

    public Phone() {

    }

    @Override
    public String toString() {
        return "phone{" +
                "phone='" + phone + '\'' +
                ", price=" + price +
                '}';
    }
}
