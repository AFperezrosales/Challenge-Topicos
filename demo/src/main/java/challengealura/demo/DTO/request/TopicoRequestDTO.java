package challengealura.demo.DTO.request;


import challengealura.demo.models.UserEntity;
import jakarta.validation.constraints.NotBlank;

public record TopicoRequestDTO(
      @NotBlank String titulo,
      @NotBlank String mensaje,
      @NotBlank String status

) {
}
