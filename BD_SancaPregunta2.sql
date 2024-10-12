CREATE DATABASE BD_SancaPregunta2;
USE BD_SancaPregunta2;

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    codigo VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255),
    rol ENUM('COORDINADOR', 'GESTOR'),
    activo BOOLEAN DEFAULT TRUE
);

INSERT INTO usuario (codigo, password, email, rol, activo) VALUES
('C001', 'password1', 'coordinador1@example.com', 'COORDINADOR', TRUE),
('C002', 'password2', 'coordinador2@example.com', 'COORDINADOR', TRUE),
('G001', 'password3', 'gestor1@example.com', 'GESTOR', TRUE),
('G002', 'password4', 'gestor2@example.com', 'GESTOR', TRUE);

CREATE TABLE producto (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

select * from producto