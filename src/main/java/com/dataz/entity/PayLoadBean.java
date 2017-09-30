/**
 * 功能描述:
 *
 * @author tommy create on 2017-09-30-10:23
 */

package com.dataz.entity;

import com.dataz.payloads.Severity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PayLoadBean {

    @NotNull(payload = {Severity.Error.class})
    @Size(min = 1, payload = {Severity.Info.class})
    private String str;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
