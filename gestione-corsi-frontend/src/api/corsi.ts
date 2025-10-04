import type { CorsoDTO } from '../types/types';
import { API_BASE, handleApiError } from './utils';

export interface FiltriCorsi {
  titolo?: string;
  luogo?: string;
  data?: string;
}

export async function fetchCorsi(filters: FiltriCorsi): Promise<CorsoDTO[]> {
  const params = new URLSearchParams();
  if (filters.titolo) params.append('titolo', filters.titolo);
  if (filters.luogo) params.append('luogo', filters.luogo);
  if (filters.data) params.append('data', filters.data);
  
  const res = await fetch(`${API_BASE}/courses?${params.toString()}`);
  if (!res.ok) {
    await handleApiError(res, 'Errore nel recupero dei corsi');
  }
  return res.json();
}