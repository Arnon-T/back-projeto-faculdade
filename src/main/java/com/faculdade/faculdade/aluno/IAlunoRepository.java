package com.faculdade.faculdade.aluno;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IAlunoRepository extends JpaRepository<Aluno, Long> {

    public List<Aluno> findAllByNomeContaining(String nome);

}
