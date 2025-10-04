// pages/CreaIscrizione.tsx
import React, { useState } from 'react';
import { useNavigate, useSearchParams } from 'react-router-dom';
import { creaIscrizione } from '../api/iscrizioni';
import { BackToHome } from '../components/BackToHome';

interface IscrizioneForm {
  partecipanteNome: string;
  partecipanteCognome: string;
  partecipanteEmail: string;
}

const CreaIscrizione: React.FC = () => {
  const [searchParams] = useSearchParams();
  const corsoId = Number(searchParams.get('corsoId'));
  const [form, setForm] = useState<IscrizioneForm>({
    partecipanteNome: '',
    partecipanteCognome: '',
    partecipanteEmail: '',
  });
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState<string | null>(null);
  const [success, setSuccess] = useState(false);
  const navigate = useNavigate();

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setForm({ ...form, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e: React.FormEvent) => {
    e.preventDefault();
    setLoading(true);
    setError(null);
    setSuccess(false);
    try {
      await creaIscrizione({ corsoId, ...form });
      setSuccess(true);
      setTimeout(() => navigate('/'), 1500);
    } catch (e: any) {
      setError(e.message);
    } finally {
      setLoading(false);
    }
  };

  if (!corsoId) {
    return <div>Manca l'ID del corso. Impossibile creare iscrizione.</div>;
  }

  return (
    <div className="crea-iscrizione-container">
      <BackToHome />
      <h1>Crea Iscrizione</h1>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          name="partecipanteNome"
          placeholder="Nome"
          value={form.partecipanteNome}
          onChange={handleChange}
          required
        />
        <input
          type="text"
          name="partecipanteCognome"
          placeholder="Cognome"
          value={form.partecipanteCognome}
          onChange={handleChange}
          required
        />
        <input
          type="email"
          name="partecipanteEmail"
          placeholder="Email"
          value={form.partecipanteEmail}
          onChange={handleChange}
          required
        />
        <button type="submit" disabled={loading}>Salva iscrizione</button>
      </form>
      {loading && <p>Salvataggio in corso...</p>}
      {error && <p className="error">{error}</p>}
      {success && <p className="success">Iscrizione creata con successo!</p>}
    </div>
  );
};

export default CreaIscrizione;