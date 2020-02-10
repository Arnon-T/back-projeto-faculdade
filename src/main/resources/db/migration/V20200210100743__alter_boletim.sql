ALTER TABLE boletim
ADD ano VARCHAR(4);
ALTER TABLE boletim
ADD CONSTRAINT UQ_id_aluno_ano UNIQUE (id_aluno, ano);