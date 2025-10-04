import { Route, Routes } from 'react-router-dom';
import Iscrizioni from './pages/Iscrizioni';
import CreaIscrizione from './pages/CreaIscrizione';
import Home from './pages/Home';

function App() {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/iscrizioni" element={<Iscrizioni />} />
      <Route path="/crea-iscrizione" element={<CreaIscrizione />} />
    </Routes>
  );
}

export default App;
