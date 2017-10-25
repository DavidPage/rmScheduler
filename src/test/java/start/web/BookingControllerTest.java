package start.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import start.service.BookingServiceImpl;
import start.web.pojos.WebBooking;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BookingControllerTest {

	@Mock
	BookingServiceImpl bookingService;

	BookingController bookingController;


	@Before
	public void setUp() throws Exception {
		this.bookingController = new BookingController(bookingService);
	}

	@Test
	public void shouldCallListAllBookingsFromService() {

		//when
		bookingController.getBookings();

		//then
		verify(bookingService).getAllBookings();
	}

	@Test
	public void shouldCallListAllBookingsByBookingIdFromService() {

		//when
		bookingController.getBookingsByBookerId(1L);

		//then
		verify(bookingService).getBookingsByBookerId(1L);
	}

	@Test
	public void shouldPassBookingOntoBookingService() throws Exception {

		final WebBooking webBooking = new WebBooking(1L, 0L);

		//when
		bookingController.createBooking(webBooking);

		//then
		verify(bookingService).createBooking(webBooking);
	}
}