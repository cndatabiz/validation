/**
 * 功能描述:
 *
 * @author tommy create on 2017-09-29-14:42
 */

package com.dataz.entity;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class PatternBean {
    private String myString;

    @NotNull(message = "{myBean.myString.null.msg}")
    @Pattern(regexp = "\\D+", message = "{myBean.myString.pattern.msg}")
    public String getMyString () {
        return myString;
    }

    public void setMyString (String myString) {
        this.myString = myString;
    }

}
