package start.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import start.entity.booking.Booking;
import start.service.BookingServiceImpl;
import start.web.pojos.WebBooking;

import java.util.Collection;

@RestController
@RequestMapping(value = "/booking")
public class BookingController {

	private BookingServiceImpl bookingService;

	BookingController(BookingServiceImpl bookingService) {
		this.bookingService = bookingService;
	}

	//shoould be used by agents
	@GetMapping("/")
	public Collection<Booking> getBookings() {
		return bookingService.getAllBookings();
	}

	@GetMapping(path = "/booker")
	public Collection<Booking> getBookingsByBookerId(@RequestParam("bookerId") Long bookerId) {
		return bookingService.getBookingsByBookerId(bookerId);
	}

	@PostMapping(path = "/book")
	public void createBooking(@RequestBody WebBooking webBooking) {
		this.bookingService.createBooking(webBooking);
	}
}
