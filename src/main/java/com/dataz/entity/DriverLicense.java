package com.dataz.entity;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class DriverLicense {
    @NotNull
//    @Valid
    private Driver driver;
    @Digits(integer = 7, fraction = 0)
    private int number;

    public DriverLicense(Driver driver, int number) {
        this.driver = driver;
        this.number = number;
    }
}
