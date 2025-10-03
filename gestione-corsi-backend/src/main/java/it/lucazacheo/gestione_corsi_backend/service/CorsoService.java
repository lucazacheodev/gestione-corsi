package it.lucazacheo.gestione_corsi_backend.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import it.lucazacheo.gestione_corsi_backend.model.Corso;
import it.lucazacheo.gestione_corsi_backend.repository.CorsoRepository;
import it.lucazacheo.gestione_corsi_backend.service.api.ICorsoService;
import it.lucazacheo.gestione_corsi_backend.util.CorsoMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class CorsoService implements ICorsoService {
    private CorsoRepository corsoRepository;
    private CorsoMapper corsoMapper;

    public CorsoService(CorsoRepository corsoRepository, CorsoMapper corsoMapper) {
        this.corsoRepository = corsoRepository;
        this.corsoMapper = corsoMapper;
    }

    @Override
    public List<Corso> getAllCorsi(String titolo, String luogo, LocalDate data) {
        return corsoRepository.findAll().stream()
                .filter(c -> titolo == null || titolo.trim().isEmpty() ||
                        c.getTitolo().toLowerCase().contains(titolo.toLowerCase()))
                .filter(c -> luogo == null || luogo.trim().isEmpty() ||
                        c.getLuogo().toLowerCase().contains(luogo.toLowerCase()))
                .filter(c -> data == null || c.getDataOraInizio().toLocalDate().equals(data))
                .filter(c -> c.getDisponibilita() > 0)
                .map(corsoMapper::toDto)
                .toList();
    }

}
