
package com.spring_101_200.test_191_200.test_195_spring_mvc_message_codes_resolver;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {

    public boolean supports(Class<?> clazz) {
        // TODO Auto-generated method stub
        return User.class.equals(clazz);
    }

    public void validate(Object obj, Errors errors) {
        // TODO Auto-generated method stub
        ValidationUtils.rejectIfEmpty(errors, "username", null, "Username is empty.");
        User user = (User) obj;
        if (null == user.getPassword() || "".equals(user.getPassword()))
            errors.rejectValue("password", null, "Password is empty.");
    }

}  