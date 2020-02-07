package com.faculdade.faculdade.materia;

import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MateriaService.class);
    private final IMateriaRepository iMateriaRepository;

    @Autowired
    public MateriaService(IMateriaRepository iMateriaRepository) {
        this.iMateriaRepository = iMateriaRepository;
    }

    public Materia save(MateriaDTO materiaDTO){
        Materia materia = new Materia();
        materia.setNome(materiaDTO.getNome());
        return this.iMateriaRepository.save(materia);
    }

    public Materia update(MateriaDTO materiaDTO, Long id){
        Materia materia = new Materia();
        materia.setNome(materiaDTO.getNome());

        return this.iMateriaRepository.save(materia);
    }

    public void deleteById(Long id){
        this.iMateriaRepository.deleteById(id);
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

    public List<Materia> saveAll(List<Materia> materias){
        List<Materia> materiasSaved = this.iMateriaRepository.saveAll(materias);
        return materiasSaved;
    }
}