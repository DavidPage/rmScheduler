package start;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import start.entity.booker.Booker;
import start.entity.booking.Booking;
import start.entity.repository.BookerRepository;
import start.service.BookingRepository;

import java.util.Collection;

import static java.util.Arrays.asList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String args[]) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(BookerRepository bookerRepository, BookingRepository bookingRepository) {
		return args -> {

			asList("david.cuevas@rightmove.co.uk,hamez@rightmove.co.uk,jorge@rightmove.com".split(",")).forEach(n -> bookerRepository.save(new Booker(n)));

			bookerRepository.findAll().forEach(b -> bookingRepository.save(new Booking(b)));

			Collection<Booker> aBooker = bookerRepository.findAll();
			Collection<Booking> bookings = bookingRepository.findAll();

			aBooker.forEach(System.out::println);
			bookings.forEach(System.out::println);
		};
	}
}
