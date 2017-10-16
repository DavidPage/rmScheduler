package start;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import start.entity.Booker;
import start.entity.BookerRepository;

import java.util.Collection;

import static java.util.Arrays.asList;

@SpringBootApplication
public class DemoApplication {

    public static void main(String args[]) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(BookerRepository bookerRepository) {
        return args -> {

            asList("David,Andreia,Luce".split(",")).forEach(n -> bookerRepository.save(new Booker(n)));

            Collection<Booker> aBooker = bookerRepository.findAll();

            aBooker.forEach(System.out::println);

        };
    }

}
