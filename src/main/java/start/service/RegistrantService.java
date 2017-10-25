package start.service;

import start.entity.booker.Registrant;

import java.util.Collection;

public interface RegistrantService {

    Collection<Registrant> getAll();

	Registrant getBookerById(Long id);
}
