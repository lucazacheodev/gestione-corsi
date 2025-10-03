package it.lucazacheo.gestione_corsi_backend.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import it.lucazacheo.gestione_corsi_backend.controller.api.ICorsoController;
import it.lucazacheo.gestione_corsi_backend.model.Corso;
import it.lucazacheo.gestione_corsi_backend.service.api.ICorsoService;

@RestController
@Validated
public class CorsoController implements ICorsoController {

    private ICorsoService corsoService;

    public CorsoController(ICorsoService corsoService) {
        this.corsoService = corsoService;
    }

    @Override
    public ResponseEntity<List<Corso>> getAllCorsi(String titolo, String luogo, LocalDate data) {

        List<Corso> corsi = corsoService.getAllCorsi(titolo, luogo, data);

        return ResponseEntity.ok(corsi);
    }

}
