package it.lucazacheo.gestione_corsi_backend.exception;


public class CorsoNotFoundException extends RuntimeException {
    private final Integer corsoId;
    
    public CorsoNotFoundException(Integer corsoId) {
        super(String.format("Il corso con id: %d non è stato trovato", corsoId));
        this.corsoId = corsoId;
    }
    
    public Integer getCorsoId() {
        return corsoId;
    }
}