package com.dataz.validate;

import com.dataz.entity.Order;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.math.BigDecimal;

public class OrderValidator implements
        ConstraintValidator<AOrder, Order> {
    @Override
    public void initialize (AOrder constraintAnnotation) {
    }

    @Override
    public boolean isValid (Order order,
                            ConstraintValidatorContext context) {
        if (order.getPrice() == null || order.getQuantity() == null) {
            return false;
        }
        return order.getTotalPrice()
                .compareTo(new BigDecimal(50)) >= 0;

    }
}