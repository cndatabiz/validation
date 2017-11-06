/**
 * 功能描述:
 *
 * @author tommy create on 2017-09-29-10:50
 */

package com.dataz;

import com.dataz.entity.Order;
import com.dataz.entity.PayLoadBean;
import com.dataz.payloads.Severity;

import javax.validation.*;
import java.math.BigDecimal;
import java.util.Set;

public class ValidationDemo3 {
    private static final Validator validator;

    //获得验证器实例
    static {
        Configuration<?> config = Validation.byDefaultProvider().configure();
        ValidatorFactory factory = config.buildValidatorFactory();
        validator = factory.getValidator();
        factory.close();
    }

    public static void main(String[] args) throws NoSuchMethodException {

        OrderClassLevelValidate();

        payLoadValidate();

    }

    public static void OrderClassLevelValidate(){
        Order order = new Order(new BigDecimal(4.5), new BigDecimal(9));

        Set<ConstraintViolation<Order>> constraintViolations =
                validator.validate(order);

        if (constraintViolations.size() > 0) {
            constraintViolations.stream().forEach(
                    ValidationDemo3::printError);
        } else {
            //proceed using order
            System.out.println(order);
        }
    }


    public static void payLoadValidate() throws NoSuchMethodException {
        PayLoadBean bean = new PayLoadBean();

        //uncommenting next line will give us info severity
        // or setting an non-empty string won't give any validation error
//        bean.setStr("");

        Set<ConstraintViolation<PayLoadBean>> constraintViolations =
                validator.validate(bean);

        boolean severeError = false;

        if (constraintViolations.size() > 0) {
            for (ConstraintViolation<PayLoadBean> violation : constraintViolations) {
                Set<Class<? extends Payload>> payloads =
                        violation.getConstraintDescriptor().getPayload();

                for (Class<? extends Payload> payload : payloads) {
                    if (payload == Severity.Error.class) {
                        severeError = true;
                        System.out.println("Error: " + violation.getPropertyPath() + " " +
                                violation.getMessage());
                    } else if (payload == Severity.Info.class) {
                        System.out.println("Info: " + violation.getPropertyPath() + " " +
                                violation.getMessage());
                    }
                }

            }
        }

        if (!severeError) {
            //continue working with bean
            System.out.println("working with : " + bean);
        }
    }


    private static void printError(ConstraintViolation violation) {
        System.out.println(violation.getPropertyPath()
                + " " + violation.getMessage());
    }

    public static class ValidationDemo4 {
        private static final Validator validator;

        //获得验证器实例
        static {
            Configuration<?> config = Validation.byDefaultProvider().configure();
            ValidatorFactory factory = config.buildValidatorFactory();
            validator = factory.getValidator();
            factory.close();
        }

        public static void main(String[] args) throws NoSuchMethodException {

            OrderClassLevelValidate();

            payLoadValidate();

        }

        public static void OrderClassLevelValidate(){
            Order order = new Order(new BigDecimal(4.5), new BigDecimal(9));

            Set<ConstraintViolation<Order>> constraintViolations =
                    validator.validate(order);

            if (constraintViolations.size() > 0) {
                constraintViolations.stream().forEach(
                        ValidationDemo4::printError);
            } else {
                //proceed using order
                System.out.println(order);
            }
        }


        public static void payLoadValidate() throws NoSuchMethodException {
            PayLoadBean bean = new PayLoadBean();

            //uncommenting next line will give us info severity
            // or setting an non-empty string won't give any validation error
    //        bean.setStr("");

            Set<ConstraintViolation<PayLoadBean>> constraintViolations =
                    validator.validate(bean);

            boolean severeError = false;

            if (constraintViolations.size() > 0) {
                for (ConstraintViolation<PayLoadBean> violation : constraintViolations) {
                    Set<Class<? extends Payload>> payloads =
                            violation.getConstraintDescriptor().getPayload();

                    for (Class<? extends Payload> payload : payloads) {
                        if (payload == Severity.Error.class) {
                            severeError = true;
                            System.out.println("Error: " + violation.getPropertyPath() + " " +
                                    violation.getMessage());
                        } else if (payload == Severity.Info.class) {
                            System.out.println("Info: " + violation.getPropertyPath() + " " +
                                    violation.getMessage());
                        }
                    }

                }
            }

            if (!severeError) {
                //continue working with bean
                System.out.println("working with : " + bean);
            }
        }


        private static void printError(ConstraintViolation violation) {
            System.out.println(violation.getPropertyPath()
                    + " " + violation.getMessage());
        }
    }
}