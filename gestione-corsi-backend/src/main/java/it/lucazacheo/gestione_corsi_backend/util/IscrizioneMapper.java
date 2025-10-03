package it.lucazacheo.gestione_corsi_backend.util;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import it.lucazacheo.gestione_corsi_backend.model.Iscrizione;
import it.lucazacheo.gestione_corsi_backend.repository.entity.IscrizioneEntity;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IscrizioneMapper {

    /**
     * Converte da IscrizioneEntity a Iscrizione DTO
     * Mappa solo il corsoId per evitare ricorsione infinita
     */
    @Mapping(target = "corsoId", source = "corso.corsoId")
    Iscrizione toDto(IscrizioneEntity entity);

    /**
     * Converte da Iscrizione DTO a IscrizioneEntity
     * Il corso viene gestito separatamente nel service
     */
    @Mapping(target = "corso", ignore = true)
    IscrizioneEntity toEntity(Iscrizione dto);
}
