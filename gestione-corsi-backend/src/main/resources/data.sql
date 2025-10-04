-- Pulisce TUTTE le tabelle e resetta gli ID
TRUNCATE TABLE iscrizioni, corsi RESTART IDENTITY CASCADE;

-- Popolazione tabella corsi
INSERT INTO corsi (titolo, data_ora_inizio, luogo, disponibilita) 
VALUES 
('Fondamenti di Java', '2025-11-15 09:00:00', 'Aula 101 - Polo Formativo', 10),
('Spring Boot Avanzato', '2025-11-20 14:30:00', 'Online', 10),
('Database Design e SQL', '2025-11-25 10:00:00', 'Aula 202 - Edificio B', 10),
('Sviluppo Web Moderno con JavaScript', '2025-12-05 09:30:00', 'Online', 10),
('DevOps per Programmatori', '2025-12-05 11:00:00', 'Aula 305 - Innovation Hub', 10),
('Microservizi con Quarkus', '2025-12-10 09:00:00', 'Aula 404 - Cloud Lab', 10);

-- Popolazione tabella iscrizioni
INSERT INTO iscrizioni (corso_id, partecipante_nome, partecipante_cognome, partecipante_email, data_ora_iscrizione)
VALUES
-- Corso 1 (Fondamenti di Java)
(1, 'Mario', 'Rossi', 'mario.rossi@email.com', '2025-10-01 08:15:00'),
(1, 'Laura', 'Bianchi', 'laura.bianchi@email.com', '2025-10-01 09:30:00'),
(1, 'Giuseppe', 'Verdi', 'giuseppe.verdi@email.com', '2025-10-02 10:45:00'),
(1, 'Chiara', 'Gallo', 'chiara.gallo@email.com', '2025-10-04 09:45:00'),
(1, 'Roberto', 'Conti', 'roberto.conti@email.com', '2025-10-05 11:20:00'),

-- Corso 2 (Spring Boot Avanzato - Online)
(2, 'Anna', 'Russo', 'anna.russo@email.com', '2025-10-01 14:20:00'),
(2, 'Paolo', 'Ferrari', 'paolo.ferrari@email.com', '2025-10-02 16:10:00'),
(2, 'Laura', 'Bianchi', 'laura.bianchi@email.com', '2025-10-03 09:00:00'),
(2, 'Elena', 'Fontana', 'elena.fontana@email.com', '2025-10-03 15:40:00'),
(2, 'Giuseppe', 'Verdi', 'giuseppe.verdi@email.com', '2025-10-04 16:25:00'),

-- Corso 3 (Database Design e SQL)
(3, 'Francesca', 'Esposito', 'francesca.esposito@email.com', '2025-10-03 11:30:00'),
(3, 'Alessandro', 'Romano', 'alessandro.romano@email.com', '2025-10-03 12:15:00'),
(3, 'Chiara', 'Gallo', 'chiara.gallo@email.com', '2025-10-04 09:45:00'),
(3, 'Davide', 'Costa', 'davide.costa@email.com', '2025-10-05 10:10:00'),
(3, 'Mario', 'Rossi', 'mario.rossi@email.com', '2025-10-05 11:50:00'),

-- Corso 4 (Sviluppo Web Moderno con JavaScript - Online)
(4, 'Davide', 'Costa', 'davide.costa@email.com', '2025-10-02 13:20:00'),
(4, 'Elena', 'Fontana', 'elena.fontana@email.com', '2025-10-03 15:40:00'),
(4, 'Silvia', 'Mancini', 'silvia.mancini@email.com', '2025-10-04 10:20:00'),
(4, 'Paolo', 'Ferrari', 'paolo.ferrari@email.com', '2025-10-05 09:15:00'),
(4, 'Anna', 'Russo', 'anna.russo@email.com', '2025-10-05 10:30:00'),

-- Corso 5 (DevOps per Programmatori)
(5, 'Roberto', 'Conti', 'roberto.conti@email.com', '2025-10-01 17:30:00'),
(5, 'Silvia', 'Mancini', 'silvia.mancini@email.com', '2025-10-04 10:20:00'),
(5, 'Alessandro', 'Romano', 'alessandro.romano@email.com', '2025-10-05 12:05:00'),
(5, 'Francesca', 'Esposito', 'francesca.esposito@email.com', '2025-10-06 08:50:00'),
(5, 'Laura', 'Bianchi', 'laura.bianchi@email.com', '2025-10-06 09:30:00'),

-- Corso 6 (Microservizi con Quarkus)
(6, 'Giuseppe', 'Verdi', 'giuseppe.verdi@email.com', '2025-10-06 11:00:00'),
(6, 'Elena', 'Fontana', 'elena.fontana@email.com', '2025-10-06 11:30:00'),
(6, 'Davide', 'Costa', 'davide.costa@email.com', '2025-10-07 09:15:00'),
(6, 'Marta', 'Leoni', 'marta.leoni@email.com', '2025-10-07 10:45:00'),
(6, 'Luca', 'Moretti', 'luca.moretti@email.com', '2025-10-07 11:20:00');
