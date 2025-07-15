package challengealura.demo.DTO.response;

import challengealura.demo.models.Topico;
import challengealura.demo.models.UserEntity;

import java.util.Date;

public record TopicosResponseDTO(

        String titulo,
        String mensaje,
        Date fechaCreacion,
        String autor
) {
    public TopicosResponseDTO(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getAutor().getNombre()
        );
    }
}
