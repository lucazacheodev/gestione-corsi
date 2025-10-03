package it.lucazacheo.gestione_corsi_backend.model;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;

// Questa classe non contiene validazioni perché non esiste un endpoint che riceva in input un Corso
@Schema(name = "CorsoDTO", description = "Rappresenta un corso con le sue iscrizioni")
public record Corso(

                @Schema(description = "ID univoco del corso", 
                accessMode = READ_ONLY, 
                example = "1") 
                Integer corsoId,

                @Schema(description = "Titolo del corso", 
                example = "Corso di Java") 
                String titolo,

                @Schema(description = "Data e ora di inizio del corso", 
                format = "date-time", example = "2024-07-01T10:00:00") 
                LocalDateTime dataOraInizio,

                @Schema(description = "luogo dove si svolge il corso", 
                example = "Aula Magna - Polo Formativo") 
                String luogo,

                @Schema(description = "Numero massimo di partecipanti al corso", 
                example = "30") 
                Integer disponibilita) {

}
