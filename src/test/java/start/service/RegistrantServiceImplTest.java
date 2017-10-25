package start.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import start.entity.repository.BookerRepository;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RegistrantServiceImplTest {

    @Mock
    BookerRepository bookerRepository;

    RegistrantServiceImpl bookerService;

    @Before
    public void setUp() throws Exception {
        this.bookerService = new RegistrantServiceImpl(bookerRepository);
    }

    @Test
    public void shouldCallServiceGetAllBookers() throws Exception {

        //when
        this.bookerService.getAll();

        //then
        verify(bookerRepository).findAll();

    }
}
