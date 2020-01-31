use master;

CREATE TABLE aluno
(
id BIGINT IDENTITY(1,1)      PRIMARY KEY NOT NULL,
nome VARCHAR(50)                         NOT NULL,
telefone INT                             NOT NULL,
email VARCHAR(50)                        NOT NULL,
endereco VARCHAR(144)                    NOT NULL
);

CREATE TABLE faculdade
(
id BIGINT IDENTITY(1,1)     PRIMARY KEY NOT NULL,
cnpj VARCHAR(14)                        NOT NULL,
razao_social VARCHAR(50)                NOT NULL,
endereco VARCHAR(144)                   NOT NULL,
telefone INT                            NOT NULL
);

CREATE TABLE materia
(
id BIGINT IDENTITY(1,1)     PRIMARY KEY NOT NULL,
id_professor                              BIGINT,
nome VARCHAR(50)                        NOT NULL,
descricao VARCHAR(255)                  NOT NULL
);

CREATE TABLE turma
(
id BIGINT IDENTITY(1,1)             PRIMARY KEY,
sala VARCHAR(15)                       NOT NULL,
codigo VARCHAR(10)                     NOT NULL,
ano DATE                               NOT NULL
);

CREATE TABLE turma_aluno
(
id_turma BIGINT FOREIGN KEY turma(id),
id_aluno BIGINT FOREIGN KEY aluno(id),

CONSTRAINT UQ_turma_aluno UNIQUE (id_turma, id_aluno);
);

CREATE TABLE turma_materia
(
id_turma BIGINT            FOREIGN KEY turma(id),
id_materia BIGINT        FOREIGN KEY materia(id)
);

CREATE TABLE professor
(
id BIGINT IDENTITY(1,1)    PRIMARY KEY NOT NULL,
telefone INT                           NOT NULL,
email VARCHAR(50)                      NOT NULL
);

CREATE TABLE professor_turma
(
id_professor BIGINT     FOREIGN KEY professor(id),
id_turma BIGINT             FOREIGN KEY turma(id),

CONSTRAINT UQ_professor_turma UNIQUE(id_professor, id_turma)
);



