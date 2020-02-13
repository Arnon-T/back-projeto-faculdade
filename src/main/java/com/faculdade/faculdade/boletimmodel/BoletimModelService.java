package com.faculdade.faculdade.boletimmodel;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoletimModelService {

    private final IBoletimModelRepository iBoletimModelRepository;

    public BoletimModelService(IBoletimModelRepository iBoletimModelRepository) {
        this.iBoletimModelRepository = iBoletimModelRepository;
    }

    public BoletimModel save(BoletimModel boletimModel){
        return this.iBoletimModelRepository.save(boletimModel);
    }

    public List<BoletimModel> saveAll(List<BoletimModel> listModel){
        return this.iBoletimModelRepository.saveAll(listModel);
    }

    public List<BoletimModel> findAllByAlunoAndAno(String aluno, String ano){
        return this.iBoletimModelRepository.findAllByAlunoAndAno(aluno, ano);
    }

    public void deleteAllByNomeAndAno(String nomeAluno, String ano){
        this.iBoletimModelRepository.deleteAllByAlunoAndAno(nomeAluno, ano);
    }
}
