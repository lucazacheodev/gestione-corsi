// hooks/useIscrizioni.ts
import { useState, useEffect } from 'react';
import type { IscrizioneDTO } from '../types/types';
import { fetchIscrizioni as apiFetchIscrizioni} from '../api/iscrizioni';
import type { FiltriIscrizioni } from '../api/iscrizioni';

export function useIscrizioni(initialFilters: FiltriIscrizioni = {}) {
  const [iscrizioni, setIscrizioni] = useState<IscrizioneDTO[]>([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);
  const [filters, setFilters] = useState<FiltriIscrizioni>(initialFilters);

  const fetchIscrizioni = async () => {
    setLoading(true);
    setError(null);
    try {
      const data = await apiFetchIscrizioni(filters);
      setIscrizioni(data);
    } catch (e: any) {
      setError(e.message);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchIscrizioni();
    // eslint-disable-next-line
  }, []);

  const updateFilters = (newFilters: Partial<FiltriIscrizioni>) => {
    setFilters(prev => ({ ...prev, ...newFilters }));
  };

  const search = () => {
    fetchIscrizioni();
  };

  return {
    iscrizioni,
    loading,
    error,
    filters,
    updateFilters,
    search,
  };
}