package start.service;

import org.springframework.stereotype.Service;
import start.entity.booker.Booker;
import start.entity.booking.Booking;
import start.service.converter.WebBookingToBookingConverter;
import start.web.pojos.WebBooking;

import java.util.Collection;

@Service
public class BookingServiceImpl implements BookingService {

	private RegistrantRepository registrantRepository;
	private RegistrantService registrantService;
	private WebBookingToBookingConverter webBookingToBookingConverter;

	public BookingServiceImpl(
			RegistrantRepository registrantRepository,
			RegistrantService bookerRepository,
			WebBookingToBookingConverter webBookingToBookingConverter) {
		this.registrantRepository = registrantRepository;
		this.registrantService = bookerRepository;
		this.webBookingToBookingConverter = webBookingToBookingConverter;
	}

	public Collection<Booking> getAllBookings() {
		return this.registrantRepository.findAll();
	}

	@Override
	public Collection<Booking> getBookingsByBookerId(Long bookerId) {
		return registrantRepository.getBookingByBookerId(bookerId);
	}

	@Override
	public void createBooking(WebBooking webBooking) {

		final Booker booker = registrantService.getBookerById(webBooking.getRegistrantId());

		final Booking booking = webBookingToBookingConverter.convert(webBooking, booker);

		registrantRepository.save(booking);
	}
}
