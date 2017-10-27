package start.service.booking;

import start.entity.booking.Booking;
import start.web.pojos.WebBooking;

import java.util.Collection;

public interface BookingService {

	Collection<Booking> getBookingsByBookerId(Long bookerId);

	void createBooking(WebBooking webBooking);
}
