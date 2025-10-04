// components/TabellaIscrizioni.tsx
import React from 'react';
import type { IscrizioneDTO } from '../types/types';

interface TabellaIscrizioniProps {
  iscrizioni: IscrizioneDTO[];
}

export const TabellaIscrizioni: React.FC<TabellaIscrizioniProps> = ({ iscrizioni }) => {
  if (iscrizioni.length === 0) {
    return <p>Nessuna iscrizione trovata.</p>;
  }

  return (
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Nome</th>
          <th>Cognome</th>
          <th>Email</th>
          <th>ID Corso</th>
        </tr>
      </thead>
      <tbody>
        {iscrizioni.map((iscr) => (
          <tr key={iscr.iscrizioneId}>
            <td>{iscr.iscrizioneId}</td>
            <td>{iscr.partecipanteNome}</td>
            <td>{iscr.partecipanteCognome}</td>
            <td>{iscr.partecipanteEmail}</td>
            <td>{iscr.corsoId}</td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};