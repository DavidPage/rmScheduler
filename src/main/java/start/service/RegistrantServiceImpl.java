package start.service;

import org.springframework.stereotype.Service;
import start.entity.booker.Booker;
import start.entity.repository.BookerRepository;

import java.util.Collection;

@Service
public class RegistrantServiceImpl implements RegistrantService {

	private BookerRepository bookerRepository;

	public RegistrantServiceImpl(BookerRepository bookerRepository) {
		this.bookerRepository = bookerRepository;
	}

	@Override
	public Collection<Booker> getAll() {
		return bookerRepository.findAll();
	}

	@Override
	public Booker getBookerById(Long id) {
		return bookerRepository.findOne(id);
	}
}
