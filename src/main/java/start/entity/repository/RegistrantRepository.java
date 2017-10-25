package start.entity.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import start.entity.booker.Registrant;

import java.util.Collection;

@RepositoryRestResource
public interface RegistrantRepository extends JpaRepository<Registrant, Long> {

    Collection<Registrant> findByEmail(@Param("email") String email);
}
