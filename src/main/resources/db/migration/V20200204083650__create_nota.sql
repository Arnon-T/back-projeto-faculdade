CREATE TABLE nota
(
id BIGINT IDENTITY(1,1)                      PRIMARY KEY NOT NULL,
id_aluno BIGINT                  FOREIGN KEY REFERENCES aluno(id),
id_materia BIGINT              FOREIGN KEY REFERENCES materia(id),
avaliacao VARCHAR(50)                                    NOT NULL,
nota DECIMAL(4,2)                                        NOT NULL
);