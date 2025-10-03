package it.lucazacheo.gestione_corsi_backend.service.api;

import java.time.LocalDate;
import java.util.List;

import it.lucazacheo.gestione_corsi_backend.model.Corso;

public interface ICorsoService {
    List<Corso> getAllCorsi(String titolo, String luogo, LocalDate data);
}
