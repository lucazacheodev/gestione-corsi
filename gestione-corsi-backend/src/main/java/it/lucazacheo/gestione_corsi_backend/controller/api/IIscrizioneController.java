package it.lucazacheo.gestione_corsi_backend.controller.api;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import it.lucazacheo.gestione_corsi_backend.model.Iscrizione;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;

@RequestMapping("/enrollments")
@Tag(name = "Iscrizioni", description = "Gestione delle iscrizioni")
public interface IIscrizioneController {
        @GetMapping
        @Operation(summary = "Recupera iscrizioni", description = "Recupera tutte le iscrizioni presenti nel Database, filtrate opzionalmente per id del corso, nome, cognome o email del partecipante")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Lista delle iscrizioni recuperata con successo", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = Iscrizione.class)))),
                        @ApiResponse(responseCode = "404", description = "Corso con id specificato non trovato", content = @Content),
                        @ApiResponse(responseCode = "400", description = "Parametri di ricerca non validi", content = @Content),
                        @ApiResponse(responseCode = "500", description = "Errore Interno del Server", content = @Content)
        })
        ResponseEntity<List<Iscrizione>> getAllEnrollments(
                        @RequestParam(required = false) @Parameter(description = "id del corso", example = "1") Integer corsoId,
                        @RequestParam(required = false) @Parameter(description = "nome del partecipante", example = "Luca") String nome,
                        @RequestParam(required = false) @Parameter(description = "cognome del partecipante", example = "Zacheo") String cognome,
                        @RequestParam(required = false) @Email(message = "{email.invalid}") @Parameter(description = "email del partecipante", example = "lucazacheo@outlook.com") String email);

        @PostMapping
        @Operation(summary = "Aggiungi iscrizione", description = "Aggiunge una nuova iscrizione ad un corso inseriti i dati del partecipante e l'id del corso")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "201", description = "Iscrizione creata con successo", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Iscrizione.class))),
                        @ApiResponse(responseCode = "400", description = "Dati in input non validi", content = @Content),
                        @ApiResponse(responseCode = "409", description = "Iscrizione già esistente per questo partecipante e corso", content = @Content),
                        @ApiResponse(responseCode = "422", description = "Corso pieno, impossibile aggiungere l'iscrizione", content = @Content),
                        @ApiResponse(responseCode = "500", description = "Errore interno del server", content = @Content)
        })
        ResponseEntity<Iscrizione> addEnrollment(@RequestBody @Valid Iscrizione iscrizioneDto);
}
