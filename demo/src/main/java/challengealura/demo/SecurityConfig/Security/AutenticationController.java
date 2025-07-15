package challengealura.demo.SecurityConfig.Security;


import challengealura.demo.DTO.request.UserRegisterRequestDTO;
import challengealura.demo.DTO.response.DatosAutentication;
import challengealura.demo.DTO.response.DatosTokenJWT;
import challengealura.demo.models.UserEntity;
import challengealura.demo.respository.IUserEntityRepository;
import challengealura.demo.service.UserEntityService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AutenticationController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private UserEntityService userEntityService;

    @PostMapping("/login")
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosAutentication datos){
        var authenticationTokentoken = new UsernamePasswordAuthenticationToken(datos.email(),datos.contrasena());
        var autentication = manager.authenticate(authenticationTokentoken);

        var tokenJWT =tokenService.generarToken((UserEntity) autentication.getPrincipal());
        return ResponseEntity.ok(new DatosTokenJWT(tokenJWT));
    }

    @PostMapping("/registrar")
    public ResponseEntity registrar(@RequestBody @Valid UserRegisterRequestDTO dto){

        userEntityService.registrarUsuario(dto);

        return ResponseEntity.accepted().body("usuario registrado con exito");
    }
}
