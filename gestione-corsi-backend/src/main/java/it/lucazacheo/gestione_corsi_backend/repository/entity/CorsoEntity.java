package it.lucazacheo.gestione_corsi_backend.repository.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "corsi")
public class CorsoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "corso_id")
    private Integer corsoId;

    @Column(name = "titolo", length = 50, nullable = false)
    private String titolo;

    @Column(name = "data_ora_inizio", nullable = false)
    private LocalDateTime dataOraInizio;

    @Column(name = "luogo", length = 100, nullable = false)
    private String luogo;

    @Column(name = "disponibilita", nullable = false)
    private Integer disponibilita;

    @OneToMany(mappedBy = "corso", fetch = FetchType.LAZY)
    private List<IscrizioneEntity> iscrizioni = new ArrayList<>();

    public void addIscrizione(IscrizioneEntity iscrizione) {
        this.iscrizioni.add(iscrizione);
        iscrizione.setCorso(this);
    }

    public void removeIscrizione(IscrizioneEntity iscrizione) {
        this.iscrizioni.remove(iscrizione);
        iscrizione.setCorso(null);
    }
}