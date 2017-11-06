package com.dataz.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

public class Driver {
    @NotNull
    private String fullName;
    @Min(100)
    private int height;
    @Past
    @NotNull
    private Date dateOfBirth;

    public Driver(String fullName, int height, Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        this.fullName = fullName;
        this.height = height;
    }
}