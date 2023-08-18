CREATE DATABASE agenda;

-- mysql
CREATE TABLE contatos(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(40),
    idade INT,
    dataCadastro DATE
)

-- postgres
CREATE TABLE contatos (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(40),
    idade INT,
    dataCadastro DATE
);