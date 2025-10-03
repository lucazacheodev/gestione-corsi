package it.lucazacheo.gestione_corsi_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.lucazacheo.gestione_corsi_backend.exception.CorsoNotFoundException;
import it.lucazacheo.gestione_corsi_backend.exception.CorsoPienoException;
import it.lucazacheo.gestione_corsi_backend.exception.IscrizioneDuplicataException;
import it.lucazacheo.gestione_corsi_backend.model.Iscrizione;
import it.lucazacheo.gestione_corsi_backend.repository.CorsoRepository;
import it.lucazacheo.gestione_corsi_backend.repository.IscrizioneRepository;
import it.lucazacheo.gestione_corsi_backend.repository.entity.CorsoEntity;
import it.lucazacheo.gestione_corsi_backend.repository.entity.IscrizioneEntity;
import it.lucazacheo.gestione_corsi_backend.service.api.IIscrizioneService;
import it.lucazacheo.gestione_corsi_backend.util.IscrizioneMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
public class IscrizioneService implements IIscrizioneService {

        private IscrizioneRepository iscrizioneRepository;
        private CorsoRepository corsoRepository;
        private IscrizioneMapper iscrizioneMapper;

        public IscrizioneService(IscrizioneRepository iscrizioneRepository, IscrizioneMapper iscrizioneMapper,
                        CorsoRepository corsoRepository) {
                this.iscrizioneRepository = iscrizioneRepository;
                this.iscrizioneMapper = iscrizioneMapper;
                this.corsoRepository = corsoRepository;
        }

        @Override
        public List<Iscrizione> getAllEnrollments(Integer corsoId, String nome,
                        String cognome, String email) {
                return iscrizioneRepository.findAll().stream()
                                .filter(i -> corsoId == null || i.getCorso().getCorsoId().equals(corsoId))
                                .filter(i -> nome == null || nome.trim().isEmpty() ||
                                                i.getPartecipanteNome().equalsIgnoreCase(nome.trim()))
                                .filter(i -> cognome == null || cognome.trim().isEmpty() ||
                                                i.getPartecipanteCognome().equalsIgnoreCase(cognome.trim()))
                                .filter(i -> email == null || email.trim().isEmpty() ||
                                                i.getPartecipanteEmail().equalsIgnoreCase(email.trim()))
                                .map(iscrizioneMapper::toDto)
                                .toList();
        }

        @Override
        public Iscrizione addIscrizione(Iscrizione iscrizioneDto) {

                CorsoEntity corso = corsoRepository.findById(iscrizioneDto.corsoId())
                                .orElseThrow(() -> new CorsoNotFoundException(iscrizioneDto.corsoId()));

                if (iscrizioneRepository.findByPartecipanteEmailAndCorso(iscrizioneDto.partecipanteEmail(),
                                corso) != null) {
                        throw new IscrizioneDuplicataException(
                                        iscrizioneDto.partecipanteEmail(),
                                        iscrizioneDto.corsoId());
                }

                if (corso.getDisponibilita() <= 0) {
                        throw new CorsoPienoException(iscrizioneDto.corsoId());
                }

                corso.setDisponibilita(corso.getDisponibilita() - 1);

                IscrizioneEntity iscrizioneToSave = iscrizioneMapper.toEntity(iscrizioneDto);
                iscrizioneToSave.setCorso(corso);

                return iscrizioneMapper.toDto(iscrizioneRepository.save(iscrizioneToSave));
        }

}
