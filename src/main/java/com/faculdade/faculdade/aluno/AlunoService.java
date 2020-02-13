package com.faculdade.faculdade.aluno;

import org.apache.commons.lang3.StringUtils;
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

    public Aluno save(AlunoDTO alunoDTO) throws TelefoneInvalidoException {

        this.validate(alunoDTO);

        return this.iAlunoRepository.save(new Aluno(alunoDTO.getNome(), alunoDTO.getTelefone(), alunoDTO.getEmail(), alunoDTO.getEndereco()));
    }

    public Aluno update(AlunoDTO alunoDTO, Long id) throws TelefoneInvalidoException {

        this.validate(alunoDTO);

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

    public List<Aluno> findAllLike(String nome) throws AlunoNaoEncontradoException {
        Optional<List<Aluno>> optionalAlunoList = this.iAlunoRepository.findAllByNomeContaining(nome);

        if(optionalAlunoList.isPresent()){
            return optionalAlunoList.get();
        }
        throw new AlunoNaoEncontradoException("Não foi possível localizar nenhum aluno.");
    }

    private void validate(AlunoDTO alunoDTO) throws TelefoneInvalidoException {
        LOGGER.info("Validando aluno.");

        if (StringUtils.isEmpty(alunoDTO.getNome())) {
            throw new IllegalArgumentException("Nome não pode ser nulo.");
        }
        if (StringUtils.isEmpty(alunoDTO.getEmail())) {
            throw new IllegalArgumentException("E-mail não pode ser nulo.");
        }
        if (StringUtils.isEmpty(alunoDTO.getEndereco())) {
            throw new IllegalArgumentException("Endereço não pode ser nulo");
        }
        if (StringUtils.isEmpty(String.valueOf(alunoDTO.getTelefone()))) {
            throw new IllegalArgumentException("Telefone não pode ser nulo.");
        }
        if (String.valueOf(alunoDTO.getTelefone()).length() < 10 || String.valueOf(alunoDTO.getTelefone()).length() > 11) {
            throw new TelefoneInvalidoException("Telefone informado é inválido");
        }
    }

}
