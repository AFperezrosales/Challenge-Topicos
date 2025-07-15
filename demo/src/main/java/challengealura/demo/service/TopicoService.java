package challengealura.demo.service;

import challengealura.demo.DTO.request.TopicoActualizarRequestDTO;
import challengealura.demo.DTO.request.TopicoRequestDTO;
import challengealura.demo.DTO.response.TopicosResponseDTO;
import challengealura.demo.models.Topico;
import challengealura.demo.models.UserEntity;
import challengealura.demo.respository.ITopicoRepository;
import challengealura.demo.respository.IUserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TopicoService {

    private final ITopicoRepository topicoRepository;
    private final IUserEntityRepository userEntityRepository;


    /*
     * 1) Post crear topico
     * 2) GET mostrar todos los topicos
     * 3) GET mostrar un tipico por id
     * 4) PUT actualizar un tipico
     * 5) DELETE eliminar un topico
     * */

    @Transactional
    public Topico crearTopico(TopicoRequestDTO dto, String email){

        Topico topico = new Topico(dto);
        topico.setAutor(userEntityRepository.buscarPorEmail(email));
        return topicoRepository.save(topico);
    }

    public List<TopicosResponseDTO> verTodosLosTopicos(){
        List<TopicosResponseDTO> response = topicoRepository.findAll().stream()
                .map(TopicosResponseDTO::new)
                .toList();
      return response;
    }


    public TopicosResponseDTO verTopicoPorID(Long id){
        Topico topico = topicoRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Error al encontrar topico"));
        return new TopicosResponseDTO(topico);

    }

    @Transactional
    public TopicosResponseDTO actualizarTopico(TopicoActualizarRequestDTO dto,String email){
        /// validacion si es el creador de ese topico

        UserEntity user = userEntityRepository.buscarPorEmail(email);

        if (topicoRepository.findByIdAndAutor(dto.id(), user).isEmpty()){
            throw new RuntimeException("Usted no creo este topico");
        }

       Topico topico = topicoRepository.getReferenceById(dto.id());
        if (!dto.titulo().isBlank() && dto.titulo() != null){
            topico.setTitulo(dto.titulo());

        }
        if (!dto.mensaje().isBlank() && dto.mensaje() != null){
            topico.setMensaje(dto.mensaje());

        }
        if (!dto.status().isBlank() && dto.status() != null){
            topico.setStatus(dto.status());

        }

        return new TopicosResponseDTO(topico);
    }

    @Transactional
    public void eliminarTopico(Long id, String email ) {
        /// validacion si es el creador de ese topico
        UserEntity user = userEntityRepository.buscarPorEmail(email);

        Topico topico = topicoRepository.findByIdAndAutor(id, user)
                .orElseThrow(() -> new RuntimeException("Usted no creó este tópico"));

        topicoRepository.deleteById(topico.getId());
    }

}
