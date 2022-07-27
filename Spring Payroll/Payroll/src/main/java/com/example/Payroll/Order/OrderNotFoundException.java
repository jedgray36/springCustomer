package com.example.Payroll.Order;

public class OrderNotFoundException extends RuntimeException {
    OrderNotFoundException(Long Id) {
        super("Could Not Find Order" + Id);
    }

}
