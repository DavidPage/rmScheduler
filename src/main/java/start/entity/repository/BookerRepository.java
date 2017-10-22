package start.entity.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import start.entity.booker.Booker;

import java.util.Collection;

@RepositoryRestResource
public interface BookerRepository extends JpaRepository<Booker, Long> {

    Collection<Booker> findByBookerName(@Param("bookerName") String bookerName);
}
