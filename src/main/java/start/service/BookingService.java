package start.service;

import start.entity.booking.Booking;

import java.util.Collection;

public interface BookingService {

	 Collection<Booking> getBookingsByBookerId(Long bookerId);
}
