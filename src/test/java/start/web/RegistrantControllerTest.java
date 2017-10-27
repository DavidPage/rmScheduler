package start.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import start.service.registrant.RegistrantService;

import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
public class RegistrantControllerTest {

    @Mock
    private RegistrantService registrantService;

    RegistrantController registrantController;

    @Before
    public void setUp() throws Exception {
        registrantController = new RegistrantController(this.registrantService);
    }

    @Test
    public void shouldCallBookersRepositoryGetAll() {

        //when
        registrantController.getBookers();

        //then
        verify(registrantService).getAll();

    }
}