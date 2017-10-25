package start.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import start.entity.booker.Booker;
import start.entity.booking.Booking;
import start.service.converter.WebBookingToBookingConverter;
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
	RegistrantRepository registrantRepository;

	@Before
	public void setUp() throws Exception {
		this.bookingService = new BookingServiceImpl(registrantRepository, registrantService, webBookingToBookingConverter);
	}

	@Test
	public void shouldReturnCollectionOfBookingsByBookerId() throws Exception {

		final Booker booker = new Booker("David");
		final Booking booking1 = new Booking(booker, 1L);
		final Booking booking2 = new Booking(booker, 2L);

		//given
		when(registrantRepository.getBookingByBookerId(1L)).thenReturn(asList(booking1, booking2));

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
		verify(registrantRepository).findAll();
	}


	//todo: test name with plenty of ANDs. Service method is doing too much. Refactor!
	@Test
	public void shouldRetrieveBookerAndConvertWebBookingAndSaveBooking() {

		final WebBooking webBooking = new WebBooking(1L, 2L);

		final Booker booker = new Booker("David");

		final Booking booking = new Booking(booker, 1L);

		//given
		when(registrantService.getBookerById(2L)).thenReturn(booker);
		when(webBookingToBookingConverter.convert(webBooking, booker)).thenReturn(booking);

		//when
		bookingService.createBooking(webBooking);

		//then
		verify(registrantRepository).save(booking);
	}
}