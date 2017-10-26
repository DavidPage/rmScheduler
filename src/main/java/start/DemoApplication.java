package start;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import start.entity.booker.Registrant;
import start.entity.booking.Booking;
import start.entity.repository.RegistrantRepository;

import java.util.Collection;

import static java.util.Arrays.asList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String args[]) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(RegistrantRepository bookerRepository, start.service.BookingRepository bookingRepository) {
		return args -> {

			asList("david.cuevas@rightmove.co.uk,hamez@rightmove.co.uk,jorge@rightmove.com".split(","))
					.forEach(n -> bookerRepository.save(new Registrant(n)));


			Long propertyId1 = 123456789L;
			Long propertyId2 = 999999999L;

			Long timestampId1 = 123456789L;
			Long timestampId2 = 999999999L;

			bookerRepository.findAll()
					.forEach(b -> {
						bookingRepository.save(new Booking(b, propertyId1, timestampId1));
						bookingRepository.save(new Booking(b, propertyId2, timestampId2));
					});

			Collection<Registrant> aRegistrant = bookerRepository.findAll();
			Collection<Booking> bookings = bookingRepository.findAll();

			aRegistrant.forEach(System.out::println);
			bookings.forEach(System.out::println);
		};
	}
}
