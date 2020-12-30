package br.gov.ce.arce.estagio.evento;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import br.gov.ce.arce.estagio.evento.model.Event;
import br.gov.ce.arce.estagio.evento.repository.EventRepository;
import br.gov.ce.arce.estagio.evento.service.EventService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {

    @InjectMocks
    EventService eventService;

    @Mock
    EventRepository eventRepository;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getEventoByIdTest() {
        Event e = new Event();
        long id = 1L;
        String nome = "NOME";
        e.setId(id);
        e.setNome(nome);
        Mockito.when(eventRepository.findById(id)).thenReturn(Optional.of(e));

        Event event = eventService.getEventoById(id);

        assertThat(event, not(nullValue()));
        assertThat(event.getId(), is(id));
        assertThat(event.getNome(), is(nome));
    }

    @Test
    public void getEventoByIdWithIdNullTest() {
        Event event = eventService.getEventoById(null);
        assertThat(event, is(nullValue()));
    }
}
