package com.faculdade.faculdade.nota;

import com.faculdade.faculdade.aluno.AlunoService;
import com.faculdade.faculdade.materia.MateriaService;
import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(NotaService.class);
    private final INotaRepository iNotaRepository;
    private final AlunoService alunoService;
    private final MateriaService materiaService;

    @Autowired
    public NotaService(INotaRepository iNotaRepository, AlunoService alunoService, MateriaService materiaService) {
        this.iNotaRepository = iNotaRepository;
        this.alunoService = alunoService;
        this.materiaService = materiaService;
    }

    public Nota save(NotaDTO notaDTO){
        Nota nota = new Nota();

        nota.setAluno(alunoService.findById(notaDTO.getIdAluno()));
        nota.setMateria(materiaService.findById(notaDTO.getIdMateria()));
        nota.setAvaliacao(notaDTO.getAvaliacao());
        nota.setNota(notaDTO.getNota());

        return this.iNotaRepository.save(nota);
    }

    public Nota update(NotaDTO notaDTO, Long id){
        Nota nota = new Nota();

        nota.setAluno(alunoService.findById(notaDTO.getIdAluno()));
        nota.setMateria(materiaService.findById(notaDTO.getIdMateria()));
        nota.setAvaliacao(notaDTO.getAvaliacao());
        nota.setNota(notaDTO.getNota());

        return this.iNotaRepository.save(nota);
    }

    public void deleteById(Long id){
        this.iNotaRepository.deleteById(id);
    }

    public Nota findById(Long id){
        Optional<Nota> notaOptional = this.iNotaRepository.findById(id);

        if(notaOptional.isPresent()){
            return notaOptional.get();
        }
        throw new ObjectNotFoundException(Nota.class, "Nota não localizada.");

    }

    public List<Nota> findAll(){
        return this.iNotaRepository.findAll();
    }
}