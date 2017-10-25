package start.service.converter;

import org.springframework.stereotype.Component;
import start.entity.booker.Booker;
import start.entity.booking.Booking;
import start.web.pojos.WebBooking;

@Component
public class WebBookingToBookingConverter {

	public Booking convert(final WebBooking webBooking, final Booker booker) {
		return new Booking(booker, webBooking.getPropertyId());
	}
}
