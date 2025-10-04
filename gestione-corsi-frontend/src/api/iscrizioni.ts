// api/iscrizioni.ts
import type { IscrizioneDTO } from '../types/types';
import { API_BASE, handleApiError } from './utils';

export interface FiltriIscrizioni {
  corsoId?: string;
  nome?: string;
  cognome?: string;
  email?: string;
}

export interface CreaIscrizioneData {
  corsoId: number;
  partecipanteNome: string;
  partecipanteCognome: string;
  partecipanteEmail: string;
}

export async function fetchIscrizioni(filters: FiltriIscrizioni): Promise<IscrizioneDTO[]> {
  const params = new URLSearchParams();
  if (filters.corsoId) params.append('corsoId', filters.corsoId);
  if (filters.nome) params.append('nome', filters.nome);
  if (filters.cognome) params.append('cognome', filters.cognome);
  if (filters.email) params.append('email', filters.email);
  
  const res = await fetch(`${API_BASE}/enrollments?${params.toString()}`);
  if (!res.ok) {
    await handleApiError(res, 'Errore nel recupero delle iscrizioni');
  }
  return res.json();
}

export async function creaIscrizione(data: CreaIscrizioneData): Promise<IscrizioneDTO> {
  const res = await fetch(`${API_BASE}/enrollments`, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify(data),
  });
  if (!res.ok) {
    await handleApiError(res, 'Errore nella creazione dell\'iscrizione');
  }
  return res.json();
}