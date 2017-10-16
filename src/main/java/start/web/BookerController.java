package start.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import start.entity.Booker;
import start.entity.BookerRepository;
import start.service.BookerService;

import java.util.Collection;

@RestController
public class BookerController {

    private BookerService bookerService;

    BookerController(BookerService bookerService) {
        this.bookerService = bookerService;
    }

    @GetMapping("/booker")
    public Collection<Booker> getBookers() {
        return bookerService.getAll();
    }
}
