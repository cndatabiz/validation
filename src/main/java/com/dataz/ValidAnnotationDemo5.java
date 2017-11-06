package com.dataz;

import com.dataz.entity.Driver;
import com.dataz.entity.DriverLicense;

import javax.validation.*;
import java.text.ParseException;
import java.util.Date;
import java.util.Set;

public class ValidAnnotationDemo5 {
    private static final Validator validator;

    //获得验证器实例
    static {
        Configuration<?> config = Validation.byDefaultProvider().configure();
        ValidatorFactory factory = config.buildValidatorFactory();
        validator = factory.getValidator();
        factory.close();
    }

    public static void main(String[] args) throws ParseException {
        Driver driver = new Driver("Joseph Waters", 60,
                new Date(System.currentTimeMillis() + 100000));
        DriverLicense dl = new DriverLicense(driver, 3454343);

        Set<ConstraintViolation<DriverLicense>> violations = validator.validate(dl);
        if (violations.size() == 0) {
            System.out.println("No violations.");
        } else {
            System.out.printf("%s violations:%n", violations.size());
            violations.stream()
                    .forEach(ValidAnnotationDemo5::printError);
        }
    }

    private static void printError(ConstraintViolation<?> violation) {
        System.out.println(violation.getPropertyPath()
                + " " + violation.getMessage());
    }
}
