package it.lucazacheo.gestione_corsi_backend.controller.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
import it.lucazacheo.gestione_corsi_backend.model.Corso;

@RequestMapping("/courses")
@Tag(name = "Corsi", description = "Gestione dei corsi")
public interface ICorsoController {
        @GetMapping
        @Operation(summary = "Recupera corsi disponibili", description = "Recupera tutti i corsi con posti ancora disponibili, filtrati opzionalmente per titolo, luogo e data")
        @ApiResponses(value = {
                        @ApiResponse(responseCode = "200", description = "Lista dei corsi recuperata con successo", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = Corso.class)))),
                        @ApiResponse(responseCode = "400", description = "Parametro di ricerca non valido", content = @Content),
                        @ApiResponse(responseCode = "500", description = "Errore Interno del Server", content = @Content)
        })
        ResponseEntity<List<Corso>> getAllCorsi(
                        @RequestParam(required = false) @Parameter(description = "titolo del corso", example = "Java Programming Base") String titolo,
                        @RequestParam(required = false) @Parameter(description = "luogo del corso", example = "Aula Magna - Polo Formativo") String luogo,
                        @RequestParam(required = false) @Parameter(description = "data del corso", example = "2024-12-31") LocalDate data);
}
