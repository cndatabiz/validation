/**
 * 功能描述:
 *
 * @author tommy create on 2017-09-29-15:48
 */

package com.dataz.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class User {
    private final String name;
    private final String phone;

    public User (@NotNull String name,
                 @NotNull
                 @Pattern(regexp = "(\\d){3,3}-\\d{3,3}-\\d{4,4}",
                         message = "must match 111-111-1111 format")
                         String phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName () {
        return name;
    }

    public String getPhone () {
        return phone;
    }
}