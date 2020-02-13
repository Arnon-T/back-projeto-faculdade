package com.faculdade.faculdade.aluno;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IAlunoRepository extends JpaRepository<Aluno, Long> {

    Optional<List<Aluno>> findAllByNomeContaining(String nome);

}
