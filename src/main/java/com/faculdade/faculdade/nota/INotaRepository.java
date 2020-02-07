package com.faculdade.faculdade.nota;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface INotaRepository extends JpaRepository<Nota, Long> {

    public List<Nota> findByAluno_Id(Long idAluno);

    public List<Nota> findByAluno_IdAndMateria_Id(Long idAluno, Long idMateria);

}
