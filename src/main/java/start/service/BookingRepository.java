package start.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import start.entity.booking.Booking;

import java.util.Collection;

@RepositoryRestResource
public interface BookingRepository extends JpaRepository<Booking, Long> {

	//todo: auxiliary method. should be deleted when the controlers are ready
	Booking save(Booking entity);

	Collection<Booking> getBookingByBookerId(Long bookerId);
}
