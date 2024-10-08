package com.animeclone.project.infrastructure.adapter.utils;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = RoleValidator.class)
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidRole {
    String message() default "El rol no es valido, debe ser ADMIN o USER.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};


}