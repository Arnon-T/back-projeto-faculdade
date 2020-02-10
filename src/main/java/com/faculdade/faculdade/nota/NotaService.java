package com.faculdade.faculdade.nota;

import com.faculdade.faculdade.aluno.AlunoService;
import com.faculdade.faculdade.materia.MateriaService;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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

        validate(notaDTO);

        nota.setAluno(alunoService.findById(notaDTO.getIdAluno()));
        nota.setMateria(materiaService.findById(notaDTO.getIdMateria()));
        nota.setTrimestre(TrimestreNota.valueOf(notaDTO.getTrimestre()));
        nota.setNota(notaDTO.getNota());

        return this.iNotaRepository.save(nota);
    }

    public Nota update(NotaDTO notaDTO, Long id){
        Nota nota = new Nota();

        validate(notaDTO);

        nota.setId(notaDTO.id);
        nota.setAluno(alunoService.findById(notaDTO.getIdAluno()));
        nota.setMateria(materiaService.findById(notaDTO.getIdMateria()));
        nota.setTrimestre(TrimestreNota.valueOf(notaDTO.getTrimestre()));
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

    public List<Nota> findAllByAlunoId(Long idAluno){
        return this.iNotaRepository.findByAluno_Id(idAluno);
    }

    public List<Nota> findAllByAlunoIdAndMateriaId(Long idAluno, Long idMateria) { return this.iNotaRepository.findByAluno_IdAndMateria_Id(idAluno, idMateria); }


    public List<Nota> findAll(){
        return this.iNotaRepository.findAll();
    }

    public void validate(NotaDTO notaDTO) {
        if (notaDTO.getNota() < 0 || notaDTO.getNota() > 10) {
            throw new IllegalArgumentException("Nota deve estar entre 0 e 10.");
        }
    }
}