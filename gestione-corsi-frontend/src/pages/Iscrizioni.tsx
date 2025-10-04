// pages/Iscrizioni.tsx
import React from 'react';
import { useSearchParams } from 'react-router-dom';
import { useIscrizioni } from '../hooks/useIscrizioni';
import { TabellaIscrizioni } from '../components/TabellaIscrizioni';
import { BackToHome } from '../components/BackToHome';

const Iscrizioni: React.FC = () => {
  const [searchParams, setSearchParams] = useSearchParams();
  const initialFilters = {
    corsoId: searchParams.get('corsoId') || '',
  };
  
  const { iscrizioni, loading, error, filters, updateFilters, search } = useIscrizioni(initialFilters);

  const handleFilterChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    updateFilters({ [e.target.name]: e.target.value });
  };

  const handleSearch = (e: React.FormEvent) => {
    e.preventDefault();
    setSearchParams({ ...filters });
    search();
  };

  let content;
  if (loading) {
    content = <p>Caricamento iscrizioni...</p>;
  } else if (error) {
    content = <p className="error">{error}</p>;
  } else {
    content = (
      <div className="iscrizioni-list">
        <TabellaIscrizioni iscrizioni={iscrizioni} />
      </div>
    );
  }

  return (
    <div className="iscrizioni-container">
      <BackToHome />
      <h1>Iscrizioni</h1>
      <form className="filters" onSubmit={handleSearch}>
        <input
          type="text"
          name="corsoId"
          placeholder="ID Corso"
          value={filters.corsoId || ''}
          onChange={handleFilterChange}
        />
        <input
          type="text"
          name="nome"
          placeholder="Nome partecipante"
          value={filters.nome || ''}
          onChange={handleFilterChange}
        />
        <input
          type="text"
          name="cognome"
          placeholder="Cognome partecipante"
          value={filters.cognome || ''}
          onChange={handleFilterChange}
        />
        <input
          type="text"
          name="email"
          placeholder="Email partecipante"
          value={filters.email || ''}
          onChange={handleFilterChange}
        />
        <button type="submit">Filtra</button>
      </form>
      {content}
    </div>
  );
};

export default Iscrizioni;