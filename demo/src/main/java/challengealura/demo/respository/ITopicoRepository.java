package challengealura.demo.respository;

import challengealura.demo.models.Topico;
import challengealura.demo.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ITopicoRepository extends JpaRepository<Topico, Long> {

    Optional<Topico> findByIdAndAutor(Long id, UserEntity autor);
}
