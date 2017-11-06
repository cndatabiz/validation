package com.dataz.entity;

import com.dataz.validate.AOrder;
import org.hibernate.validator.constraints.Range;

import java.math.BigDecimal;
import java.math.RoundingMode;

@AOrder
public class Order {
    @Range(min=1,max=10)
    private final BigDecimal price;

    private final BigDecimal quantity;

    public Order (BigDecimal price, BigDecimal quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public BigDecimal getPrice () {
        return price;
    }

    public BigDecimal getQuantity () {
        return quantity;
    }

    public BigDecimal getTotalPrice () {
        return (price != null && quantity != null ?
                price.multiply(quantity) : BigDecimal.ZERO)
                .setScale(2, RoundingMode.CEILING);
    }
}