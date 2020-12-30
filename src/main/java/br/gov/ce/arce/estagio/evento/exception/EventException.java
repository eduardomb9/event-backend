package br.gov.ce.arce.estagio.evento.exception;

public class EventException extends RuntimeException {

    public static final String MSG_EXCEPTION_ADICIONAR_PARTICIPANTE_EVENTO_INEXISTENTE = "Não foi possível adicionar o participante. Evento não encontrado.";

    public EventException(String m) {
        super(m);
    }

    public EventException(String m, Exception e) {
        super(m, e);
    }
}
