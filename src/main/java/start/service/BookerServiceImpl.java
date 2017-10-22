package start.service;

import org.springframework.stereotype.Service;
import start.entity.booker.Booker;
import start.entity.repository.BookerRepository;

import java.util.Collection;

@Service
public class BookerServiceImpl implements BookerService {

    private BookerRepository bookerRepository;

    public BookerServiceImpl(BookerRepository bookerRepository) {
        this.bookerRepository = bookerRepository;
    }

    @Override
    public Collection<Booker> getAll() {
        return bookerRepository.findAll();
    }
}