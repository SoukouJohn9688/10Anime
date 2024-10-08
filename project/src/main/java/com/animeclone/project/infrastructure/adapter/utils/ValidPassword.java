package com.animeclone.project.infrastructure.adapter.utils;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPassword {

    String message() default "La contraseña no cumple con los estandares. Debe contener por lo menos un caracter especial, mayuscual y 8 caracteres como minimo.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
