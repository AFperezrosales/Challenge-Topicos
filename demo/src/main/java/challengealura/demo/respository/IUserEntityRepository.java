package challengealura.demo.respository;

import challengealura.demo.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserEntityRepository extends JpaRepository<UserEntity, Long> {

    UserDetails findByEmail(String email);

    @Query("""
            SELECT u FROM UserEntity u 
                WHERE u.email = :email
            """)
    UserEntity buscarPorEmail(@Param("email") String email);

    boolean existsByEmail(String email);
}
