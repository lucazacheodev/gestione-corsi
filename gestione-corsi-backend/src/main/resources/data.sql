-- Pulisce TUTTE le tabelle e resetta gli ID
TRUNCATE TABLE iscrizioni, corsi RESTART IDENTITY CASCADE;

-- Popolazione tabella corsi
INSERT INTO corsi (titolo, data_ora_inizio, luogo, disponibilita) 
VALUES 
('Java Programming Base', '2025-11-15 09:00:00', 'Aula Magna - Polo Formativo', 25),
('Spring Boot Avanzato', '2025-11-20 14:30:00', 'Lab Informatica - Piano 2', 15),
('Database Design e SQL', '2025-11-25 10:00:00', 'Sala Corsi - Edificio B', 20),
('Web Development Moderno', '2025-12-01 09:30:00', 'Aula 4.0 - Innovation Hub', 30),
('DevOps Fundamentals', '2025-12-05 11:00:00', 'Lab Cloud - Data Center', 0);

-- Popolazione tabella iscrizioni
INSERT INTO iscrizioni (corso_id, partecipante_nome, partecipante_cognome, partecipante_email, data_ora_iscrizione)
VALUES
-- Iscrizioni per corso 1 (Java Base)
(1, 'Mario', 'Rossi', 'mario.rossi@email.com', '2025-10-01 08:15:00'),
(1, 'Laura', 'Bianchi', 'laura.bianchi@email.com', '2025-10-01 09:30:00'),
(1, 'Giuseppe', 'Verdi', 'giuseppe.verdi@email.com', '2025-10-02 10:45:00'),

-- Iscrizioni per corso 2 (Spring Boot)
(2, 'Anna', 'Russo', 'anna.russo@email.com', '2025-10-01 14:20:00'),
(2, 'Paolo', 'Ferrari', 'paolo.ferrari@email.com', '2025-10-02 16:10:00'),

-- Iscrizioni per corso 3 (Database)
(3, 'Francesca', 'Esposito', 'francesca.esposito@email.com', '2025-10-03 11:30:00'),
(3, 'Alessandro', 'Romano', 'alessandro.romano@email.com', '2025-10-03 12:15:00'),
(3, 'Chiara', 'Gallo', 'chiara.gallo@email.com', '2025-10-04 09:45:00'),

-- Iscrizioni per corso 4 (Web Development)
(4, 'Davide', 'Costa', 'davide.costa@email.com', '2025-10-02 13:20:00'),
(4, 'Elena', 'Fontana', 'elena.fontana@email.com', '2025-10-03 15:40:00'),

-- Iscrizioni per corso 5 (DevOps)
(5, 'Roberto', 'Conti', 'roberto.conti@email.com', '2025-10-01 17:30:00'),
(5, 'Silvia', 'Mancini', 'silvia.mancini@email.com', '2025-10-04 10:20:00');