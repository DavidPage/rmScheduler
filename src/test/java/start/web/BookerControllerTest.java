package start.web;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import start.service.RegistrantService;

import static org.mockito.Mockito.verify;

@RunWith(SpringJUnit4ClassRunner.class)
public class BookerControllerTest {

    @Mock
    private RegistrantService registrantService;

    BookerController bookerController;

    @Before
    public void setUp() throws Exception {
        bookerController = new BookerController(this.registrantService);
    }

    @Test
    public void shouldCallBookersRepositoryGetAll() {

        //when
        bookerController.getBookers();

        //then
        verify(registrantService).getAll();

    }

}