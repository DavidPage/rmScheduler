package start.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import start.entity.booker.Registrant;
import start.service.registrant.RegistrantService;

import java.util.Collection;

@RestController
public class RegistrantController {

	private RegistrantService registrantService;

	RegistrantController(RegistrantService registrantService) {
		this.registrantService = registrantService;
	}

	@GetMapping("/booker")
	public Collection<Registrant> getBookers() {
		return registrantService.getAll();
	}
}
