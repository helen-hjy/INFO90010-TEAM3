package com.example.myapplication;

public class TestDataBean {

    private int quantity;

    private String item;


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public TestDataBean(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}
