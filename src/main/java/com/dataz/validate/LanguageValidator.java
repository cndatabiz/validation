/**
 * 功能描述:
 *
 * @author tommy create on 2017-09-29-15:23
 */

package com.dataz.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Locale;

public class LanguageValidator implements ConstraintValidator<Language, String> {

    @Override
    public void initialize (Language constraintAnnotation) {
    }

    @Override
    public boolean isValid (String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        for (Locale locale : Locale.getAvailableLocales()) {
            if (locale.getDisplayLanguage().equalsIgnoreCase(value)) {
                return true;
            }
        }

        return false;
    }
}