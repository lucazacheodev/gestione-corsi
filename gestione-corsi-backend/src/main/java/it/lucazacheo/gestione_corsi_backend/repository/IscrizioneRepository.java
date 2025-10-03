package it.lucazacheo.gestione_corsi_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.lucazacheo.gestione_corsi_backend.repository.entity.CorsoEntity;
import it.lucazacheo.gestione_corsi_backend.repository.entity.IscrizioneEntity;

@Repository
public interface IscrizioneRepository extends JpaRepository<IscrizioneEntity, Integer> {

    IscrizioneEntity findByPartecipanteEmailAndCorso(String email, CorsoEntity corso);

}
