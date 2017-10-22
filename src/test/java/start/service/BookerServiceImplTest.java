package start.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import start.entity.repository.BookerRepository;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class BookerServiceImplTest {

    @Mock
    BookerRepository bookerRepository;

    BookerServiceImpl bookerService;

    @Before
    public void setUp() throws Exception {
        this.bookerService = new BookerServiceImpl(bookerRepository);
    }

    @Test
    public void shouldCallServiceGetAllBookers() throws Exception {

        //when
        this.bookerService.getAll();

        //then
        verify(bookerRepository).findAll();

    }
}
