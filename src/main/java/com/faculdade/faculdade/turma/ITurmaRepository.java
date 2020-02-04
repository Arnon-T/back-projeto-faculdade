package com.faculdade.faculdade.turma;

import com.faculdade.faculdade.aluno.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITurmaRepository extends JpaRepository<Turma, Long> {

}
