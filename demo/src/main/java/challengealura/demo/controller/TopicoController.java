package challengealura.demo.controller;

import challengealura.demo.DTO.request.TopicoActualizarRequestDTO;
import challengealura.demo.DTO.request.TopicoRequestDTO;
import challengealura.demo.DTO.response.TopicosResponseDTO;
import challengealura.demo.models.Topico;
import challengealura.demo.service.TopicoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/topico")
public class TopicoController {

   private final TopicoService topicoService;
                                       /*
                                       * 1) Post crear topico
                                       * 2) GET mostrar todos los topicos
                                       * 3) GET mostrar un tipico por id
                                       * 4) PUT actualizar un tipico
                                       * 5) DELETE eliminar un topico
                                       * */


        @PostMapping("/crear")

        public ResponseEntity<TopicosResponseDTO> crearTopico(@RequestBody @Valid TopicoRequestDTO dto, UriComponentsBuilder uriComponentsBuilder, Authentication authentication){

             Topico topico = topicoService.crearTopico(dto, authentication.getName());
                URI uri = uriComponentsBuilder.path("/topico/get/{id}").buildAndExpand(topico.getId()).toUri();
            return ResponseEntity.created(uri).body(new TopicosResponseDTO(topico));
        }

        @GetMapping("/get")
        public ResponseEntity<List<TopicosResponseDTO>> buscarTodosLosTopicos(){
            return ResponseEntity.ok(topicoService.verTodosLosTopicos());
        }



        @GetMapping("/get/{id}")
        public ResponseEntity<TopicosResponseDTO> buscarTopicoPorID(@PathVariable Long id){
            return ResponseEntity.ok(topicoService.verTopicoPorID(id));
        }

        @PutMapping("/actualizar")
        public ResponseEntity<TopicosResponseDTO> actualizarTopico(@RequestBody @Valid TopicoActualizarRequestDTO dto, Authentication authentication){
          return ResponseEntity.ok(topicoService.actualizarTopico(dto,authentication.getName()));
        }

        @DeleteMapping("/eliminar/{id}")
        public ResponseEntity eliminarTopico(@PathVariable Long id, Authentication authentication){
            topicoService.eliminarTopico(id, authentication.getName());
          return   ResponseEntity.noContent().build();
        }

}
