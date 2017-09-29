/**
 * 功能描述:
 *
 * @author tommy create on 2017-09-29-10:50
 */

package com.dataz;

import com.dataz.entity.*;

import javax.validation.*;
import java.util.Date;
import java.util.Locale;

public class ValidationDemo1 {
    private static final Validator validator;

    //获得验证器实例
    static {
        Configuration<?> config = Validation.byDefaultProvider().configure();
        ValidatorFactory factory = config.buildValidatorFactory();
        validator = factory.getValidator();
        factory.close();
    }

    public static void main(String[] args) {
        //验证字段Bean
        FieldBean fieldBean = new FieldBean();

        System.out.println("开始验证字段...");
        validator.validate(fieldBean).stream()
                .forEach(ValidationDemo1::printError);


        //验证属性
        PropertyBean propertyBean = new PropertyBean();

        System.out.println("开始验证属性...");
        validator.validate(propertyBean).stream()
                .forEach(ValidationDemo1::printError);

        //验证大小,使用内联信息
        SizeBean sizeBean= new SizeBean();
        sizeBean.setName("Mike");
        validator.validate(sizeBean).stream().forEach(ValidationDemo1::printError);


        //验证日期，覆盖缺省的消息key
        Locale.setDefault(Locale.CHINA);//Locale.FRANCE
        DateBean dateBean = new DateBean();
        dateBean.setDate(new Date(System.currentTimeMillis() - 100000));
        validator.validate(dateBean).stream()
                .forEach(ValidationDemo1::printError);


        //正在表达式验证，覆盖缺省的消息key
        PatternBean patternBean = new PatternBean();
        patternBean.setMyString("jackie10");
        validator.validate(patternBean).stream().forEach(ValidationDemo1::printError);

        //验证自定义@Language注解
        LanguageBean languageBean = new LanguageBean();
        System.out.println(Locale.getDefault().getDisplayLanguage());
        languageBean.setLanguage("China");
        validator.validate(languageBean).stream().forEach(ValidationDemo1::printError);
    }

    private static void printError(ConstraintViolation violation) {
        System.out.println(violation.getPropertyPath()
                + " " + violation.getMessage());
    }
}