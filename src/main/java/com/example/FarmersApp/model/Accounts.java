package com.example.FarmersApp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Accounts {
    @Id
    private Integer id;
    private Integer quantity;
    private  Integer price;
    private Integer balance;

    public Accounts() {}

    public Accounts(Integer id, Integer quantity, Integer price, Integer balance) {
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", balance=" + balance +
                '}';
    }

}
