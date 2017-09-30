/**
 * 功能描述:
 *
 * @author tommy create on 2017-09-30-10:22
 */

package com.dataz.payloads;


import javax.validation.Payload;

public class Severity {
    public static class Info implements Payload {
    }

    public static class Error implements Payload {
    }
}
