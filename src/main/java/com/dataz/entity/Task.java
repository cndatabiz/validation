/**
 * 功能描述:
 *
 * @author tommy create on 2017-09-29-15:54
 */

package com.dataz.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Task {
    public void run (@Size(min = 3, max = 20) String name,
                     @NotNull Runnable runnable) {
        System.out.println("starting task synchronously: " + name);
        runnable.run();
    }

}
