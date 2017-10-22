package start.service;

import org.springframework.stereotype.Service;
import start.entity.booking.Booking;

import java.util.Collection;

@Service
public class BookingServiceImpl implements BookingService {

	private BookingRepository bookingRepository;

	public BookingServiceImpl(BookingRepository bookingRepository) {
		this.bookingRepository = bookingRepository;
	}

	public Collection<Booking> getAllBookings() {
		return this.bookingRepository.findAll();
	}

	@Override
	public Collection<Booking> getBookingsByBookerId(Long bookerId) {
		return bookingRepository.getBookingByBookerId(bookerId);
	}
}
