package br.gov.ce.arce.estagio.evento.exception;

public class EventoException extends RuntimeException {

    public static final String MSG_EXCEPTION_DELETAR_EVENTO_COM_PARTICIPANTES = "Não foi possível remover o evento, pois ele contém participantes inscritos.";
    public static final String MSG_EXCEPTION_ADICIONAR_PARTICIPANTE_EVENTO_INEXISTENTE = "Não foi possível adicionar o participante. Evento não encontrado.";

    public EventoException(String m) {
        super(m);
    }

    public EventoException(String m, Exception e) {
        super(m, e);
    }
}
