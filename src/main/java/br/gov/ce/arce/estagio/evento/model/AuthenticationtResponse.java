package br.gov.ce.arce.estagio.evento.model;

public class AuthenticationtResponse {

    private String jwtToken;

    public AuthenticationtResponse(String jwtToken) {
        this.jwtToken = jwtToken;
    }
    public String getToken() {
        return this.jwtToken;
    }
}
