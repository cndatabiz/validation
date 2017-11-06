package com.dataz.validate;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = OrderValidator.class)
@Documented
public @interface AOrder {
    String message () default "total price must be 50 or greater for online order. " +
            "Found: ${validatedValue.totalPrice}";
    Class<?>[] groups () default {};
    Class<? extends Payload>[] payload () default {};
}