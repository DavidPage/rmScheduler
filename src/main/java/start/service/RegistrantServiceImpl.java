package start.service;

import org.springframework.stereotype.Service;
import start.entity.booker.Registrant;
import start.entity.repository.RegistrantRepository;

import java.util.Collection;

@Service
public class RegistrantServiceImpl implements RegistrantService {

	private RegistrantRepository registrantRepository;

	public RegistrantServiceImpl(RegistrantRepository registrantRepository) {
		this.registrantRepository = registrantRepository;
	}

	@Override
	public Collection<Registrant> getAll() {
		return registrantRepository.findAll();
	}

	@Override
	public Registrant getBookerById(Long id) {
		return registrantRepository.findOne(id);
	}
}
