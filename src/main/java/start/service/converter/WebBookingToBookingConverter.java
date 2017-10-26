package start.service.converter;

import org.springframework.stereotype.Component;
import start.entity.booker.Registrant;
import start.entity.booking.Booking;
import start.web.pojos.WebBooking;

@Component
public class WebBookingToBookingConverter {

	public Booking convert(final WebBooking webBooking, final Registrant registrant) {
		return new Booking(registrant, webBooking.getPropertyId(), webBooking.getTimestamp());
	}
}
