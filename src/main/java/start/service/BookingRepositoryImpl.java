package start.service;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public abstract class BookingRepositoryImpl {

	public List<String> getBookingByEmail(String emailAddress) {
		return null;
	}
}
