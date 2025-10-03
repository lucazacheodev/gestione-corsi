package it.lucazacheo.gestione_corsi_backend.exception;

public class CorsoPienoException extends RuntimeException {
    private final Integer corsoId;

    public CorsoPienoException(Integer corsoId) {
        super(String.format("Il corso con id: %d è pieno e non accetta nuove iscrizioni", corsoId));
        this.corsoId = corsoId;
    }

    public Integer getCorsoId() {
        return corsoId;
    }

}
