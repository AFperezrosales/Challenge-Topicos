package challengealura.demo.Exceptions;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GestorDeExcepciones {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity gestionarError404NOTFOUND() {

        return ResponseEntity.notFound().build();
    }

    /// excepcion MethodArgumentNotValid ahora mandara un dto con los campos que estan mal
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity gestionarError400(MethodArgumentNotValidException ex) {
        var errores = ex.getFieldErrors();
        return ResponseEntity.badRequest().body(errores.stream().map(DatosErrorValidacionDTO::new).toList());
    }


    /// record para mandar el dto de los datos faltantes
    public record DatosErrorValidacionDTO(String campo, String mensaje){
        public DatosErrorValidacionDTO (FieldError error){
            this(error.getField(),error.getDefaultMessage());
        }
    }
}
