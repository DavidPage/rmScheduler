package start.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import start.entity.Booker;
import start.entity.BookerRepository;

import java.util.Collection;

@RestController
public class BookerController {

    private BookerRepository bookerRepository;

    BookerController(BookerRepository bookerRepository) {
        this.bookerRepository = bookerRepository;
    }

    @GetMapping("/booker")
    public Collection<Booker> getBookers() {
        return bookerRepository.findAll();
    }
}
