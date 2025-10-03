package it.lucazacheo.gestione_corsi_backend.util;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import it.lucazacheo.gestione_corsi_backend.model.Corso;
import it.lucazacheo.gestione_corsi_backend.repository.entity.CorsoEntity;

@Mapper(componentModel = "spring", uses = {
        IscrizioneMapper.class }, injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CorsoMapper {

    /**
     * Converte da CorsoEntity a Corso DTO
     * Include le iscrizioni mappate tramite IscrizioneMapper
     */

    Corso toDto(CorsoEntity entity);
}