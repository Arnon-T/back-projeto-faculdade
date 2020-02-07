use master;

CREATE TABLE aluno
(
id BIGINT IDENTITY(1,1)      PRIMARY KEY NOT NULL,
nome VARCHAR(50)                         NOT NULL,
telefone INT                             NOT NULL,
email VARCHAR(50)                        NOT NULL,
endereco VARCHAR(144)                    NOT NULL
);

CREATE TABLE materia
(
id BIGINT IDENTITY(1,1)     PRIMARY KEY NOT NULL,
nome VARCHAR(50)                        NOT NULL,
);

CREATE TABLE nota
(
id BIGINT IDENTITY(1,1)                      PRIMARY KEY NOT NULL,
id_aluno BIGINT                  FOREIGN KEY(id_aluno) REFERENCES aluno(id),
id_materia BIGINT              FOREIGN KEY (id_materia) REFERENCES materia(id),
trimeste VARCHAR(2)                                      NOT NULL,
nota DECIMAL(4,2)                                        NOT NULL,

CONSTRAINT UQ_aluno_materia_trimestre UNIQUE (id_aluno, id_materia, trimeste)
);

CREATE TABLE boletim
(
id BIGINT IDENTITY(1,1) PRIMARY KEY NOT NULL,
id_aluno BIGINT NOT NULL,

FOREIGN KEY (id_aluno) REFERENCES aluno(id)
)

CREATE TABLE boletim_nota
(
id_boletim BIGINT FOREIGN KEY (id_boletim) REFERENCES boletim(id),
id_nota BIGINT FOREIGN KEY (id_nota) REFERENCES nota(id),

CONSTRAINT UQ_boletim_nota UNIQUE (id_boletim, id_nota)
)
