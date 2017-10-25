package start;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import start.entity.booker.Booker;
import start.entity.booking.Booking;
import start.entity.repository.BookerRepository;
import start.service.RegistrantRepository;

import java.util.Collection;

import static java.util.Arrays.asList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String args[]) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(BookerRepository bookerRepository, RegistrantRepository registrantRepository) {
		return args -> {

			asList("david.cuevas@rightmove.co.uk,hamez@rightmove.co.uk,jorge@rightmove.com".split(","))
					.forEach(n -> bookerRepository.save(new Booker(n)));


			Long propertyId1 = 123456789L;
			Long propertyId2 = 999999999L;

			bookerRepository.findAll()
					.forEach(b -> {
						registrantRepository.save(new Booking(b, propertyId1));
						registrantRepository.save(new Booking(b, propertyId2));
					});

			Collection<Booker> aBooker = bookerRepository.findAll();
			Collection<Booking> bookings = registrantRepository.findAll();

			aBooker.forEach(System.out::println);
			bookings.forEach(System.out::println);
		};
	}
}
