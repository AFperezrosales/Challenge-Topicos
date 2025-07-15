package challengealura.demo.service;


import challengealura.demo.DTO.request.UserRegisterRequestDTO;
import challengealura.demo.models.UserEntity;
import challengealura.demo.respository.IUserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    IUserEntityRepository userEntityRepository;

    public void registrarUsuario(UserRegisterRequestDTO dto){
        if (userEntityRepository.existsByEmail(dto.email())) {
            throw new IllegalArgumentException("El email ya está registrado");
        }

        UserEntity usuario = UserEntity.builder()
                .email(dto.email())
                .contrasena(passwordEncoder.encode(dto.contrasena()))
                .nombre(dto.nombre())
                .build();

        userEntityRepository.save(usuario);

    }

}
