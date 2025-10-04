// hooks/useCorsi.ts
import { useEffect, useState } from 'react';
import { fetchCorsi as apiFetchCorsi } from '../api/corsi';
import type { FiltriCorsi } from '../api/corsi';
import type { CorsoDTO } from '../types/types';

export function useCorsi(initialFilters: FiltriCorsi = {}) {
  const [corsi, setCorsi] = useState<CorsoDTO[]>([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);
  const [filters, setFilters] = useState<FiltriCorsi>(initialFilters);

  const fetchCorsi = async () => {
    setLoading(true);
    setError(null);
    try {
      const data = await apiFetchCorsi(filters);
      setCorsi(data);
    } catch (e: any) {
      setError(e.message);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchCorsi();
    // eslint-disable-next-line
  }, []);

  const updateFilters = (newFilters: Partial<FiltriCorsi>) => {
    setFilters(prev => ({ ...prev, ...newFilters }));
  };

  const search = () => {
    fetchCorsi();
  };

  return {
    corsi,
    loading,
    error,
    filters,
    updateFilters,
    search,
  };
}