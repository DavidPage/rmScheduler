package start.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import start.entity.booker.Booker;
import start.entity.booking.Booking;

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
	BookingRepository bookingRepository;

	@Before
	public void setUp() throws Exception {
		this.bookingService = new BookingServiceImpl(bookingRepository);
	}

	@Test
	public void shouldReturnCollectionOfBookingsByBookerId() throws Exception {

		final Booker booker = new Booker("David");
		final Booking booking = new Booking(booker);

		//given
		when(bookingRepository.getBookingByBookerId(1L)).thenReturn(asList(booking));

		//when
		Collection<Booking> actualBookings = this.bookingService.getBookingsByBookerId(1L);

		//then
		List<Booking> expectedBookings = asList(booking);
		assertThat(actualBookings).isEqualTo(expectedBookings);
	}

	@Test
	public void shouldCallRepositoryFindAllBookings() {

		//when
		bookingService.getAllBookings();

		//then
		verify(bookingRepository).findAll();
	}
}