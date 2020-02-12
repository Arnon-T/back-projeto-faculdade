package com.faculdade.faculdade.nota;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface INotaRepository extends JpaRepository<Nota, Long> {

    Optional<List<Nota>> findByAluno_Id(Long idAluno);

    Optional<List<Nota>> findByAluno_IdAndMateria_Id(Long idAluno, Long idMateria);

}
