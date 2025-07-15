package challengealura.demo.DTO.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegisterRequestDTO(
       @NotBlank String nombre,
       @Email    String email,
       @NotBlank String contrasena
) {
}
