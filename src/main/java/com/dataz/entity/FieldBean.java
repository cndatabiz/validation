/**
 * 功能描述:
 *
 * @author tommy create on 2017-09-29-10:51
 */

package com.dataz.entity;

import javax.validation.constraints.NotNull;

public class FieldBean {
    @NotNull
    private String str;

    public String getStr () {
        return str;
    }

    public void setStr (String str) {
        this.str = str;
    }
}
