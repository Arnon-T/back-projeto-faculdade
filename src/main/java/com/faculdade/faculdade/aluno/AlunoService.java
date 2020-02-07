package com.faculdade.faculdade.aluno;

import com.faculdade.faculdade.materia.Materia;
import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoService.class);
    private final IAlunoRepository iAlunoRepository;

    @Autowired
    public AlunoService(IAlunoRepository iAlunoRepository) { this.iAlunoRepository = iAlunoRepository; }

    public Aluno save(AlunoDTO alunoDTO){
        return this.iAlunoRepository.save(new Aluno(alunoDTO.getNome(), alunoDTO.getTelefone(), alunoDTO.getEmail(), alunoDTO.getEndereco()));
    }

    public Aluno update(AlunoDTO alunoDTO, Long id){
        Aluno aluno = new Aluno();
        aluno.setId(id);
        aluno.setNome(alunoDTO.getNome());
        aluno.setEmail(alunoDTO.getEmail());
        aluno.setEndereco(alunoDTO.getEndereco());
        aluno.setTelefone(alunoDTO.getTelefone());

        return this.iAlunoRepository.save(aluno);
    }

    public void deleteById(Long id){
        this.iAlunoRepository.deleteById(id);
    }

    public Aluno findById(Long id){
        Optional<Aluno> alunoOptional = this.iAlunoRepository.findById(id);

        if(alunoOptional.isPresent()){
            return alunoOptional.get();
        }
        throw new ObjectNotFoundException(Aluno.class, "O aluno não foi localizado");

    }


    public List<Aluno> findAll(){
        return this.iAlunoRepository.findAll();
    }

    public List<Aluno> saveAll(List<Aluno> alunos){
        return this.iAlunoRepository.saveAll(alunos);
    }

    public List<Aluno> findAllLike(String nome){
        return this.iAlunoRepository.findAllByNomeContaining(nome);
    }
}
