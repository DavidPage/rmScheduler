package start.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import start.entity.repository.RegistrantRepository;
import start.service.registrant.RegistrantServiceImpl;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class RegistrantServiceImplTest {

    @Mock
    RegistrantRepository registrantRepository;

    RegistrantServiceImpl bookerService;

    @Before
    public void setUp() throws Exception {
        this.bookerService = new RegistrantServiceImpl(registrantRepository);
    }

    @Test
    public void shouldCallServiceGetAllBookers() throws Exception {

        //when
        this.bookerService.getAll();

        //then
        verify(registrantRepository).findAll();

    }
}
