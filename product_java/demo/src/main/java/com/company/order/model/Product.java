package com.company.order.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.io.Serializable;


public class Product implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Наименование товара обязательно")
    @Pattern(regexp = "[a-zA-Zа-яА-ЯёЁ]+", message = "Наименование товара должно содержать только буквы")
    private String productName;

    @NotNull(message = "Количество товара обязательно")
    @Min(value = 0, message = "Количество товара не может быть отрицательным")
    private int quantities;

    @NotNull(message = "Оплаченная сумма обязательна")
    @Min(value = 0, message = "Оплаченная сумма не может быть отрицательной")
    private int amount;


    public Product(Long id, String productName, int quantities, int amount) {
        this.id = id;
        this.productName = productName;
        this.quantities = quantities;
        this.amount = amount;
    }

    public Product() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantities() {
        return quantities;
    }

    public void setQuantities(int quantities) {
        this.quantities = quantities;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
