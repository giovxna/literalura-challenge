CREATE TABLE IF NOT EXISTS autor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    data_nascimento DATE,
    data_falecimento DATE
);

CREATE TABLE IF NOT EXISTS livro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor_id BIGINT,
    idioma VARCHAR(10),
    genero VARCHAR(255),
    downloads INT,
    FOREIGN KEY (autor_id) REFERENCES autor(id)
);
