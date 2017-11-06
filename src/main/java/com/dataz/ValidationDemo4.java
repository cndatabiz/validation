/**
 * 功能描述:
 *
 * @author tommy create on 2017-09-29-10:50
 */

package com.dataz;

import com.dataz.entity.GroupBean;
import com.dataz.groups.GroupAddress;
import com.dataz.groups.GroupName;
import com.dataz.groups.GroupSequenceForGroupBean;

import javax.validation.*;
import java.util.Set;

public class ValidationDemo4 {
    private static final Validator validator;

    //获得验证器实例
    static {
        Configuration<?> config = Validation.byDefaultProvider().configure();
        ValidatorFactory factory = config.buildValidatorFactory();
        validator = factory.getValidator();
        factory.close();
    }

    public static void main(String[] args) throws NoSuchMethodException {

//        validateOneGroup();
//        validateTwoGroup();
//        validateDefaultGroup();

//        validateGroupOrder1();
          validateGroupOrder2();
    }




    /**
     * 验证一个组
     */
    public static void validateOneGroup(){
        GroupBean groupBean = new GroupBean();
        groupBean.setFirstName("Jennifer");
        //  user.setLastName("Wilson");

        Set<ConstraintViolation<GroupBean>> constraintViolations =
                validator.validate(groupBean, GroupName.class);

        if (constraintViolations.size() > 0) {
            constraintViolations.stream().forEach(
                    ValidationDemo4::printError);
        } else {
            //proceed using user object
            System.out.println(groupBean);
        }
    }

    /**
     * 验证两个组
     */
    public static void validateTwoGroup(){
        GroupBean groupBean = new GroupBean();
        groupBean.setFirstName("Jennifer");
        //  user.setLastName("Wilson");

        Set<ConstraintViolation<GroupBean>> constraintViolations =
                validator.validate(groupBean, GroupName.class, GroupAddress.class);

        if (constraintViolations.size() > 0) {
            constraintViolations.stream().forEach(
                    ValidationDemo4::printError);
        } else {
            //proceed using user object
            System.out.println(groupBean);
        }
    }


    /**
     * 验证缺省组
     */
    public static void validateDefaultGroup(){
        GroupBean groupBean = new GroupBean();
        groupBean.setFirstName("Jennifer");
        //  user.setLastName("Wilson");

        Set<ConstraintViolation<GroupBean>> constraintViolations =
                validator.validate(groupBean);

        if (constraintViolations.size() > 0) {
            constraintViolations.stream().forEach(
                    ValidationDemo4::printError);
        } else {
            //proceed using user object
            System.out.println(groupBean);
        }
    }

    /**
     * 验证组顺序（定义顺序类）：第一个组验证失败，直接短路。
     */
    public static void validateGroupOrder1(){
        GroupBean groupBean = new GroupBean();
        groupBean.setFirstName("Jennifer");
        //  groupBean.setLastName("Wilson");
        groupBean.setGroupId("001");

        Set<ConstraintViolation<GroupBean>> constraintViolations =
                validator.validate(groupBean, GroupSequenceForGroupBean.class);

        if (constraintViolations.size() > 0) {
            constraintViolations.stream().forEach(
                    ValidationDemo4::printError);
        } else {
            //proceed using user object
            System.out.println(groupBean);
        }
    }

    /**
     * 验证组顺序（注解验证类）：第一个组验证失败，直接短路。
     */
    public static void validateGroupOrder2(){
        GroupBean groupBean = new GroupBean();
        groupBean.setFirstName("Jennifer");
        //  groupBean.setLastName("Wilson");
        groupBean.setGroupId("001");

        Set<ConstraintViolation<GroupBean>> constraintViolations =
                validator.validate(groupBean);

        if (constraintViolations.size() > 0) {
            constraintViolations.stream().forEach(
                    ValidationDemo4::printError);
        } else {
            //proceed using user object
            System.out.println(groupBean);
        }
    }

    private static void printError(ConstraintViolation violation) {
        System.out.println(violation.getPropertyPath()
                + " " + violation.getMessage());
    }


}