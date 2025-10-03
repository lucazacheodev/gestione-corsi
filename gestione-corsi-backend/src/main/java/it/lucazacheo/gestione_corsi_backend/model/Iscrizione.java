package it.lucazacheo.gestione_corsi_backend.model;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;

@Schema(name = "IscrizioneDTO", description = "Rappresenta un'iscrizione ad un corso")
public record Iscrizione(

                @Schema(description = "ID univoco dell'iscrizione", 
                        accessMode = READ_ONLY, 
                        example = "1")
                @Null(message = "{null}")
                Integer iscrizioneId,

                @Schema(description = "ID del corso a cui l'utente si è iscritto", 
                        example = "1")
                @NotNull(message = "{not.null}")
                Integer corsoId,

                @Schema(description = "Nome del partecipante", 
                        example = "Luca")
                @Size(max = 30, message = "{size.max}")
                @NotBlank(message = "{not.empty}") 
                String partecipanteNome,

                @Schema(description = "Cognome del partecipante", 
                        example = "Zacheo")
                @NotBlank(message = "{not.empty}")
                @Size(max = 30, message = "{size.max}")
                String partecipanteCognome,

                @Schema(description = "Email del partecipante", 
                        example = "lucazacheo@outlook.com")
                @NotBlank(message = "{not.empty}") 
                @Size(max = 50, message = "{size.max}") 
                @Email(message = "{email.invalid}")
                String partecipanteEmail,

                @Schema(description = "Data e ora dell'iscrizione", 
                        accessMode = READ_ONLY, 
                        format = "date-time", 
                        example = "2024-06-15T14:30:00")
                @Null(message = "{null}") 
                LocalDateTime dataOraIscrizione) {
}