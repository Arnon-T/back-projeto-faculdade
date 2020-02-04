package com.faculdade.faculdade.professor;

import com.faculdade.faculdade.materia.MateriaService;
import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfessorService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProfessorService.class);
    private final IProfessorRepository iProfessorRepository;

    @Autowired
    public ProfessorService(IProfessorRepository iProfessorRepository) {
        this.iProfessorRepository = iProfessorRepository;
    }

    public Professor save(ProfessorDTO professorDTO){
        Professor professor = new Professor();
        professor.setNome(professorDTO.getNome());
        professor.setTelefone(professorDTO.getTelefone());
        professor.setEmail(professorDTO.getEmail());
        professor.setEndereco(professorDTO.getEndereco());

        return this.iProfessorRepository.save(professor);
    }

    public Professor update(ProfessorDTO professorDTO, Long id){
        Professor professor = new Professor();

        professor.setNome(professorDTO.getNome());
        professor.setTelefone(professorDTO.getTelefone());
        professor.setEmail(professorDTO.getEmail());
        professor.setEndereco(professorDTO.getEndereco());

        return this.iProfessorRepository.save(professor);
    }

    public void deleteById(Long id){
        this.iProfessorRepository.deleteById(id);
    }

    public Professor findById(Long id){
        Optional<Professor> professorOptional = this.iProfessorRepository.findById(id);

        if(professorOptional.isPresent()){
            return professorOptional.get();
        }
        throw new ObjectNotFoundException(Professor.class, "Professor não localizada.");

    }

    public List<Professor> findAll(){
        return this.iProfessorRepository.findAll();
    }
}