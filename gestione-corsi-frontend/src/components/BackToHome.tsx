// components/BackToHome.tsx
import { Link } from 'react-router-dom';

export const BackToHome = () => (
  <Link to="/" style={{ textDecoration: 'none', color: '#1976d2', fontWeight: 'bold' }}>
    &larr; Torna alla Home
  </Link>
);