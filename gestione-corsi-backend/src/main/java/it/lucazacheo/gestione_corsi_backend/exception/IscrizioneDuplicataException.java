package it.lucazacheo.gestione_corsi_backend.exception;

public class IscrizioneDuplicataException extends RuntimeException {
    private final String email;
    private final Integer corsoId;

    public IscrizioneDuplicataException(String email, Integer corsoId) {
        super(String.format("L'iscrizione per email %s al corso %d è già presente nel nostro database",
                email, corsoId));
        this.email = email;
        this.corsoId = corsoId;
    }

    public String getEmail() {
        return email;
    }

    public Integer getCorsoId() {
        return corsoId;
    }
}