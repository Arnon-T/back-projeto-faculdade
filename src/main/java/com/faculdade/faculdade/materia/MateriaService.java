package com.faculdade.faculdade.materia;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {

    private final IMateriaRepository iMateriaRepository;

    @Autowired
    public MateriaService(IMateriaRepository iMateriaRepository) {
        this.iMateriaRepository = iMateriaRepository;
    }

    public Materia findById(Long id){
        Optional<Materia> materiaOptional = this.iMateriaRepository.findById(id);

        if(materiaOptional.isPresent()){
            return materiaOptional.get();
        }
        throw new ObjectNotFoundException(Materia.class, "Materia não localizada.");

    }

    public List<Materia> findAll(){
        return this.iMateriaRepository.findAll();
    }

}