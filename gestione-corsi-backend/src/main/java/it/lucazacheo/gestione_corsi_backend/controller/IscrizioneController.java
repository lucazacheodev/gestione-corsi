package it.lucazacheo.gestione_corsi_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import it.lucazacheo.gestione_corsi_backend.controller.api.IIscrizioneController;
import it.lucazacheo.gestione_corsi_backend.model.Iscrizione;
import it.lucazacheo.gestione_corsi_backend.service.api.IIscrizioneService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@Validated
public class IscrizioneController implements IIscrizioneController {
    private IIscrizioneService iscrizioneService;

    public IscrizioneController(IIscrizioneService iscrizioneService) {
        this.iscrizioneService = iscrizioneService;
    }

    @Override
    public ResponseEntity<List<Iscrizione>> getAllEnrollments(Integer corsoId, String nome, String cognome,
            String email) {

        List<Iscrizione> iscrizioni = iscrizioneService.getAllEnrollments(corsoId, nome, cognome, email);
        return ResponseEntity.ok(iscrizioni);
    }

    @Override
    public ResponseEntity<Iscrizione> addEnrollment(Iscrizione iscrizioneDto) {

        return new ResponseEntity<>(iscrizioneService.addIscrizione(iscrizioneDto), HttpStatus.CREATED);
    }

}
