package start.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import start.entity.booker.Registrant;
import start.entity.booking.Booking;
import start.entity.repository.BookingRepository;
import start.service.booking.BookingServiceImpl;
import start.service.converter.WebBookingToBookingConverter;
import start.service.registrant.RegistrantService;
import start.web.pojos.WebBooking;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookingServiceImplTest {

	BookingServiceImpl bookingService;

	@Mock
	WebBookingToBookingConverter webBookingToBookingConverter;

	@Mock
	RegistrantService registrantService;

	@Mock
	BookingRepository bookingRepository;

	@Before
	public void setUp() throws Exception {
		this.bookingService = new BookingServiceImpl(bookingRepository, registrantService, webBookingToBookingConverter);
	}

	@Test
	public void shouldReturnCollectionOfBookingsByBookerId() throws Exception {

		final Registrant registrant = new Registrant("David");
		final Booking booking1 = new Booking(registrant, 1L, 123456789L);
		final Booking booking2 = new Booking(registrant, 2L, 123456789L);

		//given
		when(bookingRepository.getBookingByRegistrantId(1L)).thenReturn(asList(booking1, booking2));

		//when
		Collection<Booking> actualBookings = this.bookingService.getBookingsByBookerId(1L);

		//then
		List<Booking> expectedBookings = asList(booking1, booking2);
		assertThat(actualBookings).isEqualTo(expectedBookings);
	}

	@Test
	public void shouldCallRepositoryFindAllBookings() {

		//when
		bookingService.getAllBookings();

		//then
		verify(bookingRepository).findAll();
	}


	//todo: test name with plenty of ANDs. Service method is doing too much. Refactor!
	@Test
	public void shouldRetrieveBookerAndConvertWebBookingAndSaveBooking() {

		final WebBooking webBooking = new WebBooking(1L, 2L, 123456789L);

		final Registrant registrant = new Registrant("David");

		final Booking booking = new Booking(registrant, 1L, webBooking.getTimestamp());

		//given
		when(registrantService.getBookerById(2L)).thenReturn(registrant);
		when(webBookingToBookingConverter.convert(webBooking, registrant)).thenReturn(booking);

		//when
		bookingService.createBooking(webBooking);

		//then
		verify(bookingRepository).save(booking);
	}
}