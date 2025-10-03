package it.lucazacheo.gestione_corsi_backend.repository.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "iscrizioni", uniqueConstraints = {
        @UniqueConstraint(columnNames = { "corso_id", "partecipante_email" }, name = "UK_corso_partecipante_email") })
public class IscrizioneEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iscrizione_id")
    private Integer iscrizioneId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "corso_id")
    private CorsoEntity corso;

    @Column(name = "partecipante_nome", length = 30, nullable = false)
    private String partecipanteNome;

    @Column(name = "partecipante_cognome", length = 30, nullable = false)
    private String partecipanteCognome;

    @Column(name = "partecipante_email", length = 50, nullable = false)
    private String partecipanteEmail;

    @Column(name = "data_ora_iscrizione", nullable = false, updatable = false)
    private LocalDateTime dataOraIscrizione;

    @PrePersist
    protected void onCreate() {
        dataOraIscrizione = LocalDateTime.now();
    }
}