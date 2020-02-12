package com.faculdade.faculdade.boletim;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IBoletimRepository extends JpaRepository<Boletim, Long> {

    Optional<Boletim> findByAluno_Id(Long idAluno);

    void deleteAllByAluno_Id(Long idAluno);

}
