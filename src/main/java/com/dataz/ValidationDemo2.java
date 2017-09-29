/**
 * 功能描述:
 *
 * @author tommy create on 2017-09-29-10:50
 */

package com.dataz;

import com.dataz.entity.*;

import javax.validation.*;
import javax.validation.executable.ExecutableValidator;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

public class ValidationDemo2 {
    private static final Validator validator;

    //获得验证器实例
    static {
        Configuration<?> config = Validation.byDefaultProvider().configure();
        ValidatorFactory factory = config.buildValidatorFactory();
        validator = factory.getValidator();
        factory.close();
    }

    public static void main(String[] args) throws NoSuchMethodException {
        //构造函数参数演示
        constructorParameterValidate();

        //方法参数演示
        mothedParameterValidate();
    }

    public static void constructorParameterValidate() throws NoSuchMethodException {
        String userName = null;
        String userPhone = "223-223-222";

        Constructor<User> constructor =
                User.class.getConstructor(String.class, String.class);

        ExecutableValidator executableValidator = validator.forExecutables();
        Set<ConstraintViolation<User>> constraintViolations =
                executableValidator.validateConstructorParameters(constructor,
                        new Object[]{userName, userPhone});

        if (constraintViolations.size() > 0) {
            constraintViolations.stream().forEach(
                    ValidationDemo2::printError);
        } else {
            User user = new User(userName, userPhone);
            System.out.println(user);
        }
    }

    public static void mothedParameterValidate() throws NoSuchMethodException {

        Task task = new Task();
        String taskName = "a";
        Runnable runnable = null;

        Method method = Task.class.getDeclaredMethod("run",
                new Class[]{String.class, Runnable.class});

        ExecutableValidator executableValidator = validator.forExecutables();
        Set<ConstraintViolation<Task>> violations =
                executableValidator.validateParameters(task, method,
                        new Object[]{taskName, runnable});

        if (violations.size() > 0) {
            violations.stream().forEach(ValidationDemo2::printError);
        } else {
            task.run(taskName, runnable);
        }
    }


    private static void printError(ConstraintViolation violation) {
        System.out.println(violation.getPropertyPath()
                + " " + violation.getMessage());
    }
}