package com.animeclone.project.infrastructure.adapter.auth;

import com.animeclone.project.infrastructure.adapter.utils.ValidPassword;
import com.animeclone.project.infrastructure.adapter.utils.ValidRole;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDTO {

    @NotNull( message = "El correo es obligatorio")
    @NotBlank( message = "El correo no debe estar en blanco")
    @Email
    private String email;
    @NotNull ( message = "La contraseña no debe estar en blanco")
    @NotBlank( message = "La contraseña no debe estar en blanco")
    @Length(min = 8, max = 20,message = "La contrasena debe contener un minimo de 8 characteres")
    @ValidPassword
    private String password;
    @NotNull( message = "El nombre de usuario es obligatorio")
    @NotBlank( message = "El nombre de usuario no debe estar en blanco")
    private String username;

    @ValidRole
    @NotNull( message = "El rol es obligatorio")
    @NotBlank( message = "El rol no debe estar en blanco")
    private String role;
}