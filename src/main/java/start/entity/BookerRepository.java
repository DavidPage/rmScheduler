package start.entity;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface BookerRepository extends JpaRepository<Booker, Long>{

    Collection<Booker> findByBookerName( String bookerName);
}
