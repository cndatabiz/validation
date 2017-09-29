/**
 * 功能描述:
 *
 * @author tommy create on 2017-09-29-14:43
 */

package com.dataz.entity;

import javax.validation.constraints.Size;

public class SizeBean {
    @Size(min = 5, message = "The name '${validatedValue}' must be at least {min}" +
            " characters long. Length found : '${validatedValue.length()}'")
    private String name;

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }
}
