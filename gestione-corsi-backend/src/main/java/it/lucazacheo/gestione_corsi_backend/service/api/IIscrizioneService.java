package it.lucazacheo.gestione_corsi_backend.service.api;

import java.util.List;

import it.lucazacheo.gestione_corsi_backend.model.Iscrizione;

public interface IIscrizioneService {
    List<Iscrizione> getAllEnrollments(Integer corsoId, String nome, String cognome, String email);

    Iscrizione addIscrizione(Iscrizione iscrizioneDto);

}
