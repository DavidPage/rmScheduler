package start.service;

import start.entity.booker.Booker;

import java.util.Collection;

public interface RegistrantService {

    Collection<Booker> getAll();

	Booker getBookerById(Long id);
}
