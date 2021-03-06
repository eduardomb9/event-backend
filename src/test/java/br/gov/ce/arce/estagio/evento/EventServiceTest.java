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
        long id = 1L;
        String nome = "NOME";

        Event eventActual = new Event();
        eventActual.setId(id);
        eventActual.setNome(nome);

        Event eventExpected = new Event();
        eventExpected.setId(id);
        eventExpected.setNome(nome);

        Mockito.when(eventRepository.findById(id)).thenReturn(Optional.of(eventActual));

        Event event = eventService.getEventoById(id);

        assertThat(event, not(nullValue()));
        assertThat(event, is(eventExpected));
    }

    @Test
    public void getEventoByIdWithIdNullTest() {
        Event event = eventService.getEventoById(null);
        assertThat(event, is(nullValue()));
    }
}
