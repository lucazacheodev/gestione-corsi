// components/CorsoCard.tsx
import React from 'react';
import type { CorsoDTO } from '../types/types';

interface CorsoCardProps {
  corso: CorsoDTO;
  onShowIscrizioni: (corsoId: number) => void;
  onIscriviti: (corsoId: number) => void;
}

export const CorsoCard: React.FC<CorsoCardProps> = ({ 
  corso, 
  onShowIscrizioni, 
  onIscriviti 
}) => {
  return (
    <div className="corso-card">
      <h2>{corso.titolo}</h2>
      <p><b>Luogo:</b> {corso.luogo}</p>
      <p><b>Data inizio:</b> {new Date(corso.dataOraInizio).toLocaleString()}</p>
      <p><b>Disponibilità:</b> {corso.disponibilita}</p>
      <button 
        type="button" 
        onClick={() => onShowIscrizioni(corso.corsoId)}
      >
        Iscrizioni
      </button>
      <button 
        type="button" 
        style={{marginLeft: '1rem'}} 
        onClick={() => onIscriviti(corso.corsoId)}
      >
        Iscriviti
      </button>
    </div>
  );
};