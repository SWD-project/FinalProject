package com.example.finalproject.model.dto;

import java.util.List;

public class CheckoutRequest {
    private List<String> cartDetailId;
    private int payment;

    public CheckoutRequest() {
    }

    public CheckoutRequest(List<String> cartDetailId, int payment) {
        this.cartDetailId = cartDetailId;
        this.payment = payment;
    }

    public List<String> getCartDetailId() {
        return cartDetailId;
    }

    public void setCartDetailId(List<String> cartDetailId) {
        this.cartDetailId = cartDetailId;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }
}
