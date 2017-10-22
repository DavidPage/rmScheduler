package start.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import start.service.BookingServiceImpl;

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
		bookingService.getAllBookings();
	}

	@Test
	public void shouldCallListAllBookingsByBookingIdFromService() {

		//when
		bookingController.getBookingsByBookerId(1L);

		//then
		bookingService.getBookingsByBookerId(1L);
	}
}