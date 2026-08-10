-- ============================================================
-- Dragon Ball MZ — Datos de prueba
-- Base de datos: dragonball
-- Tablas: armas, ataques, peleador, peleador_arma, peleador_ataque
-- ============================================================

USE dragonball;

-- ============================================================
-- 50 ARMAS
-- Columnas: id, nombre, bonificadorDanio, peso
-- ============================================================
INSERT INTO armas (nombre, bonificadorDanio, peso) VALUES
('Bastón Extensible de Goku', 80, 1.2),
('Espada Z de Trunks', 95, 3.5),
('Espada de Tapión', 90, 4.0),
('Lanza de Beerus', 120, 2.8),
('Bastón de Korin', 60, 0.9),
('Espada de Zamasu', 110, 3.2),
('Cañón Galick', 100, 0.0), -- arma de ki
('Escudo de Androide 17', 70, 5.0),
('Pistola de Láser del Dr. Gero', 85, 1.5),
('Maza de Nappa', 75, 8.0),
('Espada Sagrada de Kibito', 105, 3.8),
('Bastón de Garlic Jr.', 65, 1.1),
('Hacha de Dabura', 115, 6.5),
('Lanza de Zarbon', 78, 2.2),
('Guantes de Androide 18', 72, 0.5),
('Cañón de Cell Jr.', 88, 0.0),
('Escudo de Babidi', 55, 3.0),
('Espada del Supremo Kai', 102, 4.1),
('Pistola de Bulma (láser)', 50, 0.4),
('Cadena de Oro de Pilaf', 45, 2.0),
('Espada Rota de Future Trunks', 92, 3.3),
('Látigo de Frieza', 98, 0.0), -- cola
('Garras de Cooler', 96, 0.0),
('Hoja de Hielo de Frost', 87, 0.0),
('Disco Kienzan', 130, 0.0), -- ki
('Bastón de Piccolo (Namek)', 68, 1.3),
('Cañón Buster de Trunks SSJ', 118, 0.0),
('Espada de Hit', 108, 0.0),
('Bisturí de ki de Dr. Wheelo', 82, 0.0),
('Lanza Saiyajin Élite', 88, 4.5),
('Maza de Broly', 125, 9.0),
('Katana de Gohan (entrenamiento)', 76, 1.8),
('Espada del Tiempo de Chronoa', 115, 2.5),
('Cañón de Rayo de Androide 19', 90, 0.0),
('Pistola Vibrante de Tao Pai Pai', 83, 1.0),
('Bisturí del Dr. Myuu', 79, 0.3),
('Bastón de Uranai Baba', 58, 0.8),
('Hacha de Raditz', 74, 5.5),
('Lanza de los Ginyu', 80, 3.0),
('Espada de Bojack', 103, 4.2),
('Cuchillo de Sombra de Janemba', 112, 0.0),
('Espada del Demonio de Shula', 97, 3.7),
('Tridente de Turles', 86, 4.8),
('Maza de Slug', 93, 7.0),
('Garras de Metal Cooler', 107, 0.0),
('Látigo de Haze Shenron', 70, 0.0),
('Espada de Syn Shenron', 119, 5.0),
('Lanza de Eis Shenron', 101, 3.9),
('Guantelete de Nuova Shenron', 113, 1.5),
('Espada Oscura de Demigra', 122, 4.6);


-- ============================================================
-- 50 ATAQUES
-- Columnas: id, nombre, danioBase, costoEnergia
-- ============================================================
INSERT INTO ataques (nombre, danioBase, costoEnergia) VALUES
('Kamehameha', 150, 50),
('Kame Kame Ha Final', 200, 80),
('Onda Vital', 180, 70),
('Galick Ho', 140, 45),
('Big Bang Attack', 160, 60),
('Final Flash', 190, 75),
('Destructo Disco (Kienzan)', 170, 55),
('Makankosappo', 155, 50),
('Masenko', 130, 40),
('Super Explosive Wave', 145, 48),
('Death Beam', 135, 35),
('Death Ball', 210, 90),
('Nova Strike', 165, 58),
('Eraser Cannon', 175, 65),
('Omega Blaster', 220, 95),
('Hell Gate Attack', 195, 78),
('Solar Flare', 30, 10), -- cegador
('Instant Kamehameha', 185, 72),
('Father-Son Kamehameha', 230, 100),
('Tri-Beam (Kikoho)', 160, 65),
('Self Destruct Energy', 250, 120), -- sacrificio
('Vanishing Ball', 215, 88),
('Special Beam Cannon Max', 200, 82),
('Power Ball', 100, 30), -- transformación
('Negative Energy Blast', 205, 85),
('Double Sunday', 140, 42),
('Energy Dan', 120, 35),
('Crusher Ball', 155, 50),
('Psychic Move', 110, 28),
('Super Ghost Kamikaze Attack', 175, 68),
('Dragon Fist', 225, 95),
('Super Kamehameha', 195, 80),
('Ultimate Kamehameha', 240, 105),
('Revenge Death Ball', 235, 102),
('Gigantic Meteor', 220, 92),
('Blaster Ball', 145, 45),
('Galick Burst', 165, 60),
('Buster Cannon', 175, 65),
('Atomic Blast', 190, 76),
('Dark Death Beam', 160, 55),
('Hakai (Destrucción)', 300, 150), -- dios
('Ultra Instinct Strike', 270, 130),
('Silver Dragon Flash', 245, 108),
('Transcendent God Kamehameha', 260, 125),
('Kaio-Ken x20', 200, 90), -- multiplicador
('Burning Attack', 155, 52),
('Stardust Breaker', 210, 88),
('Continuous Die Die Missile', 180, 70),
('Energy Charge', 80, 20), -- carga
('Spirit Bomb Super', 280, 140);


-- ============================================================
-- 50 PELEADORES
-- Columnas: id, nombre, puntosVida, energia, defensaBase
-- ============================================================
INSERT INTO peleador (nombre, puntosVida, energia, defensaBase) VALUES
('Goku', 9000, 8500, 75.0),
('Vegeta', 8500, 8000, 72.0),
('Gohan', 8000, 7800, 70.0),
('Piccolo', 7500, 7200, 68.0),
('Trunks', 7800, 7600, 71.0),
('Goten', 6500, 6300, 60.0),
('Krillin', 5500, 5200, 58.0),
('Yamcha', 4500, 4200, 50.0),
('Tenshinhan', 5800, 5600, 60.0),
('Chiaotzu', 3500, 3200, 40.0),
('Frieza', 9200, 9000, 80.0),
('Cell', 9000, 8800, 78.0),
('Majin Buu (Gordo)', 10000, 9500, 85.0),
('Kid Buu', 9800, 9600, 82.0),
('Broly', 10500,10000, 88.0),
('Cooler', 8800, 8600, 76.0),
('Raditz', 6000, 5800, 62.0),
('Nappa', 7000, 6800, 67.0),
('Zarbon', 6800, 6500, 65.0),
('Dodoria', 6500, 6000, 63.0),
('Ginyu', 7500, 7200, 68.0),
('Recoome', 7200, 6900, 66.0),
('Burter', 7000, 6800, 65.0),
('Jeice', 6800, 6600, 64.0),
('Guldo', 5000, 4800, 52.0),
('Android 17', 8200, 8000, 73.0),
('Android 18', 8000, 7800, 72.0),
('Android 16', 8500, 0, 80.0), -- sin ki natural
('Dr. Gero / Android 20', 7000, 6800, 65.0),
('Cell Jr.', 6000, 5800, 60.0),
('Vegito', 11000,10500, 90.0),
('Gogeta', 11000,10500, 90.0),
('Gotenks', 8500, 8300, 74.0),
('Future Trunks', 8200, 8000, 73.0),
('Bardock', 6500, 6200, 63.0),
('King Vegeta', 7000, 6700, 66.0),
('Turles', 7200, 7000, 67.0),
('Slug (Lord Slug)', 7500, 7200, 69.0),
('Bojack', 8000, 7800, 72.0),
('Janemba', 9500, 9200, 81.0),
('Tapion', 7000, 6800, 65.0),
('Hirudegarn', 10000, 9000, 86.0),
('Beerus', 15000,15000, 97.0),
('Whis', 20000,20000, 99.0),
('Zamasu', 9800, 9600, 83.0),
('Goku Black', 9500, 9300, 82.0),
('Hit', 9000, 8700, 79.0),
('Jiren', 12000,11500, 92.0),
('Syn Shenron', 9600, 9400, 84.0),
('Omega Shenron', 11500,11000, 91.0);


-- ============================================================
-- RELACIONES PELEADOR ↔ ARMA (peleador_arma)
-- Cada peleador con 1-3 armas representativas
-- ============================================================
INSERT INTO peleador_arma (peleador_id, arma_id) VALUES
(1, 1), -- Goku → Bastón Extensible
(2, 7), -- Vegeta → Cañón Galick (ki)
(3, 32), -- Gohan → Katana entrenamiento
(4, 26), -- Piccolo → Bastón Namek
(5, 2), -- Trunks → Espada Z
(5, 21), -- Trunks → Espada Rota
(11, 22), -- Frieza → Látigo (cola)
(11, 24), -- Frieza → Hoja de Hielo de Frost (similar)
(12, 16), -- Cell → Cañón Cell Jr.
(13, 17), -- Majin Buu → Escudo Babidi
(26, 8), -- Android 17 → Escudo
(27, 15), -- Android 18 → Guantes
(33, 27), -- Gotenks → Cañón Buster SSJ
(34, 21), -- Future Trunks → Espada Rota
(43, 2), -- Beerus → Lanza Beerus (id 4 → corregido a id 2 para ejemplo)
(45, 6), -- Zamasu → Espada Zamasu
(47, 28), -- Hit → Espada de Hit
(48, 50), -- Jiren — sin arma típica, usa Espada Oscura Demigra como placeholder
(49, 47), -- Syn Shenron → Látigo Haze Shenron
(50, 48); -- Omega Shenron → Espada Syn Shenron


-- ============================================================
-- RELACIONES PELEADOR ↔ ATAQUE (peleador_ataque)
-- Cada peleador con sus ataques característicos
-- ============================================================
INSERT INTO peleador_ataque (peleador_id, ataque_id) VALUES
-- Goku
(1, 1), -- Kamehameha
(1, 3), -- Onda Vital
(1, 18), -- Instant Kamehameha
(1, 31), -- Dragon Fist
(1, 45), -- Kaio-Ken x20
-- Vegeta
(2, 4), -- Galick Ho
(2, 5), -- Big Bang Attack
(2, 6), -- Final Flash
(2, 37), -- Galick Burst
-- Gohan
(3, 9), -- Masenko
(3, 19), -- Father-Son Kamehameha
(3, 32), -- Super Kamehameha
-- Piccolo
(4, 8), -- Makankosappo
(4, 10), -- Super Explosive Wave
-- Trunks
(5, 38), -- Buster Cannon
(5, 46), -- Burning Attack
(5, 27), -- Cañón Buster (como Buster Cannon)
-- Krillin
(7, 7), -- Destructo Disco
(7, 17), -- Solar Flare
-- Tenshinhan
(9, 20), -- Tri-Beam
-- Chiaotzu
(10, 21), -- Self Destruct Energy
-- Frieza
(11, 11), -- Death Beam
(11, 12), -- Death Ball
(11, 22), -- Vanishing Ball
-- Cell
(12, 13), -- Nova Strike
(12, 23), -- Special Beam Cannon Max
(12, 47), -- Stardust Breaker
-- Majin Buu
(13, 36), -- Blaster Ball
(13, 34), -- Revenge Death Ball
-- Kid Buu
(14, 25), -- Negative Energy Blast
(14, 34), -- Revenge Death Ball
-- Broly
(15, 14), -- Eraser Cannon
(15, 15), -- Omega Blaster
(15, 35), -- Gigantic Meteor
-- Cooler
(16, 13), -- Nova Strike
-- Goten
(6, 2), -- Kame Kame Ha Final
-- Vegito
(31, 33), -- Ultimate Kamehameha
(31, 41), -- Hakai
-- Gogeta
(32, 33), -- Ultimate Kamehameha
(32, 47), -- Stardust Breaker
-- Gotenks
(33, 30), -- Super Ghost Kamikaze Attack
-- Bardock
(35, 9), -- Masenko
-- Janemba
(40, 16), -- Hell Gate Attack
-- Beerus
(43, 41), -- Hakai
-- Zamasu
(45, 40), -- Dark Death Beam
(45, 44), -- Transcendent God Kamehameha
-- Goku Black
(46, 44), -- Transcendent God Kamehameha
-- Hit
(47, 43), -- Silver Dragon Flash
-- Jiren
(48, 42), -- Ultra Instinct Strike
-- Omega Shenron
(50, 48); -- Continuous Die Die Missile
