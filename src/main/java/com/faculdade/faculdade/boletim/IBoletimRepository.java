package com.faculdade.faculdade.boletim;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IBoletimRepository extends JpaRepository<Boletim, Long> {

    public Boletim findByAluno_Id(Long idAluno);

    public void deleteAllByAluno_Id(Long idAluno);

}
