/**
 * 功能描述:
 *
 * @author tommy create on 2017-09-29-14:39
 */

package com.dataz.entity;

import javax.validation.constraints.Future;
import java.util.Date;

public class DateBean {
    @Future
    private Date date;

    public Date getDate () {
        return date;
    }

    public void setDate (Date date) {
        this.date = date;
    }
}
