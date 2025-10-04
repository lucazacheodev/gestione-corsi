import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import type { CorsoDTO } from './types/types';
import { API_BASE, handleApiError } from './api/utils';

const Home: React.FC = () => {
  const navigate = useNavigate();
  const [corsi, setCorsi] = useState<CorsoDTO[]>([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);
  const [filters, setFilters] = useState({ titolo: '', luogo: '', data: '' });

  const fetchCorsi = async () => {
    setLoading(true);
    setError(null);
    try {
      const params = new URLSearchParams();
      if (filters.titolo) params.append('titolo', filters.titolo);
      if (filters.luogo) params.append('luogo', filters.luogo);
      if (filters.data) params.append('data', filters.data);
      
      const res = await fetch(`${API_BASE}/courses?${params.toString()}`);
      if (!res.ok) {
        await handleApiError(res, 'Errore nel recupero dei corsi');
      }
      setCorsi(await res.json());
    } catch (e: any) {
      setError(e.message);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchCorsi();
  }, []);

  const handleFilterChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setFilters({ ...filters, [e.target.name]: e.target.value });
  };

  const handleSearch = (e: React.FormEvent) => {
    e.preventDefault();
    fetchCorsi();
  };

  const handleShowIscrizioni = (corsoId: number) => {
    navigate(`/iscrizioni?corsoId=${corsoId}`);
  };

  let content;
  if (loading) {
    content = <p>Caricamento corsi...</p>;
  } else if (error) {
    content = <p className="error">{error}</p>;
  } else {
    let corsiContent;
    if (corsi.length === 0) {
      corsiContent = <p>Nessun corso trovato.</p>;
    } else {
      // Ordina i corsi per ID crescente
      const corsiOrdinati = [...corsi].sort((a, b) => a.corsoId - b.corsoId);
      corsiContent = corsiOrdinati.map((corso) => (
        <div key={corso.corsoId} className="corso-card">
          <h2>{corso.titolo}</h2>
          <p><b>Luogo:</b> {corso.luogo}</p>
          <p><b>Data inizio:</b> {new Date(corso.dataOraInizio).toLocaleString()}</p>
          <p><b>Disponibilità:</b> {corso.disponibilita}</p>
          <button type="button" onClick={() => handleShowIscrizioni(corso.corsoId)}>
            Iscrizioni
          </button>
          <button type="button" style={{marginLeft: '1rem'}} onClick={() => navigate(`/crea-iscrizione?corsoId=${corso.corsoId}`)}>
            Iscriviti
          </button>
        </div>
      ));
    }
    content = <div className="corsi-list">{corsiContent}</div>;
  }

  return (
    <div className="home-container">
      <h1>Elenco Corsi</h1>
      <form className="filters" onSubmit={handleSearch}>
        <input
          type="text"
          name="titolo"
          placeholder="Titolo"
          value={filters.titolo}
          onChange={handleFilterChange}
        />
        <input
          type="text"
          name="luogo"
          placeholder="Luogo"
          value={filters.luogo}
          onChange={handleFilterChange}
        />
        <input
          type="date"
          name="data"
          value={filters.data}
          onChange={handleFilterChange}
        />
        <button type="submit">Cerca</button>
      </form>
      {content}
    </div>
  );
};

export default Home;