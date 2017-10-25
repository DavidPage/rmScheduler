package start.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import start.entity.booker.Booker;
import start.service.RegistrantService;

import java.util.Collection;

@RestController
public class BookerController {

	private RegistrantService registrantService;

	BookerController(RegistrantService registrantService) {
		this.registrantService = registrantService;
	}

	@GetMapping("/booker")
	public Collection<Booker> getBookers() {
		return registrantService.getAll();
	}
}
