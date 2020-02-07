CREATE TABLE boletim_model
(
id BIGINT IDENTITY(1,1)                   PRIMARY KEY NOT NULL,
aluno VARCHAR(50)                                     NOT NULL,
ano VARCHAR(4)                                        NOT NULL,
materia VARCHAR(50)                                   NOT NULL,
nota1 VARCHAR(5)                                      NOT NULL,
nota2 VARCHAR(5)                                      NOT NULL,
nota3 VARCHAR(5)                                      NOT NULL,
nota4 VARCHAR(5)                                      NOT NULL,
media VARCHAR(5)                                      NOT NULL,

CONSTRAINT UQ_aluno_ano_materia UNIQUE (aluno, ano, materia)
);