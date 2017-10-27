package start.service.booking;

import org.springframework.stereotype.Service;
import start.entity.booker.Registrant;
import start.entity.booking.Booking;
import start.entity.repository.BookingRepository;
import start.service.registrant.RegistrantService;
import start.service.converter.WebBookingToBookingConverter;
import start.web.pojos.WebBooking;

import java.util.Collection;

@Service
public class BookingServiceImpl implements BookingService {

	private BookingRepository registrantRepository;
	private RegistrantService registrantService;
	private WebBookingToBookingConverter webBookingToBookingConverter;

	public BookingServiceImpl(
			BookingRepository registrantRepository,
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
		return registrantRepository.getBookingByRegistrantId(bookerId);
	}

	@Override
	public void createBooking(WebBooking webBooking) {

		final Registrant registrant = registrantService.getBookerById(webBooking.getRegistrantId());

		final Booking booking = webBookingToBookingConverter.convert(webBooking, registrant);

		registrantRepository.save(booking);
	}
}
