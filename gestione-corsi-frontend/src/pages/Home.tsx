// pages/Home.tsx
import React from 'react';
import { useNavigate } from 'react-router-dom';
import { useCorsi } from '../hooks/useCorsi';
import { CorsoCard } from '../components/CorsoCard';

const Home: React.FC = () => {
  const navigate = useNavigate();
  const { corsi, loading, error, filters, updateFilters, search } = useCorsi();

  const handleFilterChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    updateFilters({ [e.target.name]: e.target.value });
  };

  const handleSearch = (e: React.FormEvent) => {
    e.preventDefault();
    search();
  };

  const handleShowIscrizioni = (corsoId: number) => {
    navigate(`/iscrizioni?corsoId=${corsoId}`);
  };

  const handleIscriviti = (corsoId: number) => {
    navigate(`/crea-iscrizione?corsoId=${corsoId}`);
  };

  let content;
  if (loading) {
    content = <p>Caricamento corsi...</p>;
  } else if (error) {
    content = <p className="error">{error}</p>;
  } else if (corsi.length === 0) {
    content = <p>Nessun corso trovato.</p>;
  } else {
    content = (
      <div className="corsi-list">
        {corsi.map((corso) => (
          <CorsoCard
            key={corso.corsoId}
            corso={corso}
            onShowIscrizioni={handleShowIscrizioni}
            onIscriviti={handleIscriviti}
          />
        ))}
      </div>
    );
  }

  return (
    <div className="home-container">
      <h1>Corsi disponibili</h1>
      <form className="filters" onSubmit={handleSearch}>
        <input
          type="text"
          name="titolo"
          placeholder="Titolo"
          value={filters.titolo || ''}
          onChange={handleFilterChange}
        />
        <input
          type="text"
          name="luogo"
          placeholder="Luogo"
          value={filters.luogo || ''}
          onChange={handleFilterChange}
        />
        <input
          type="date"
          name="data"
          value={filters.data || ''}
          onChange={handleFilterChange}
        />
        <button type="submit">Cerca</button>
      </form>
      {content}
    </div>
  );
};

export default Home;