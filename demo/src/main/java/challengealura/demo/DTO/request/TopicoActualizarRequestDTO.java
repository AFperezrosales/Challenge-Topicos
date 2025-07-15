package challengealura.demo.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record TopicoActualizarRequestDTO(
        @NotNull Long id,
        String titulo,
        String mensaje,
        String status
) {
}
