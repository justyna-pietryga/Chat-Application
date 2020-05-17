package com.example.chat.model.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = LoginUniqueValidator.class)
public @interface ValidLoginUnique {
    String message() default "Login already exists";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
