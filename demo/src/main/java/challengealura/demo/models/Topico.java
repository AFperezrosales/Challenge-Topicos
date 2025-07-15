package challengealura.demo.models;

import challengealura.demo.DTO.request.TopicoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Locale;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String mensaje;

    private Date fechaCreacion;

    private String status;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private UserEntity autor;

    public Topico(TopicoRequestDTO dto) {
        this.titulo = dto.titulo();
        this.mensaje = dto.mensaje();
        this.fechaCreacion = Date.valueOf(LocalDate.now());
        this.status = dto.status();
    }
}
