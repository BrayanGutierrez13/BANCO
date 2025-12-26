CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    documento VARCHAR(30) NOT NULL UNIQUE
);

DROP TABLE IF EXISTS clientes;

INSERT INTO cliente (nombre, documento)
VALUES 
('Juan Pérez', '123456789'),
('María Gómez', '987654321');

SELECT * FROM cliente;
