package start.service.converter;

import org.junit.Before;
import org.junit.Test;
import start.entity.booker.Registrant;
import start.entity.booking.Booking;
import start.web.pojos.WebBooking;

import static org.assertj.core.api.Assertions.assertThat;

public class WebBookingToBookingConverterTest {

	private WebBookingToBookingConverter converter;

	@Before
	public void setup() {
		this.converter = new WebBookingToBookingConverter();
	}

	@Test
	public void shouldConvertAWebBookingToDomainOne() {

		final WebBooking webBooking = new WebBooking(1L, 2L, 3L);
		final Registrant registrant = new Registrant("David");

		//when
		final Booking domainBooking = converter.convert(webBooking, registrant);

		//then
		final Booking expectedBooking = new Booking(registrant, 1L);

		assertThat(domainBooking).isEqualTo(expectedBooking);
	}
}