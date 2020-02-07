package com.faculdade.faculdade.boletimModel;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IBoletimModelRepository extends JpaRepository<BoletimModel, Long> {

    public List<BoletimModel> findAllByAlunoAndAno(String aluno, String ano);

    public void deleteAllByAlunoAndAno(String aluno, String ano);

}
