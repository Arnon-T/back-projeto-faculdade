package com.faculdade.faculdade.turma;

import com.faculdade.faculdade.aluno.Aluno;
import com.faculdade.faculdade.aluno.AlunoService;
import com.faculdade.faculdade.materia.Materia;
import com.faculdade.faculdade.materia.MateriaService;
import com.faculdade.faculdade.professor.Professor;
import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TurmaService {
    private static final Logger LOGGER = LoggerFactory.getLogger(TurmaService.class);
    private final ITurmaRepository iTurmaRepository;
    private final MateriaService materiaService;
    private final AlunoService alunoService;

    @Autowired
    public TurmaService(ITurmaRepository iTurmaRepository, MateriaService materiaService, AlunoService alunoService) {
        this.iTurmaRepository = iTurmaRepository;
        this.materiaService = materiaService;
        this.alunoService = alunoService;
    }

    @Transactional
    public Turma save(TurmaDTO turmaDTO){
        Turma turma = new Turma();
        turma.setSala(turmaDTO.getSala());
        turma.setCodigo(turmaDTO.getCodigo());
        turma.setAno(turmaDTO.getAno());
        turma.setListMaterias(this.materiaService.saveAll(this.parseListIdMateriastoMaterias(turmaDTO.getIdMaterias())));
        turma.setListAlunos(this.alunoService.saveAll(this.parseListIdAlunostoAlunos(turmaDTO.getIdAlunos())));

        return this.iTurmaRepository.save(turma);
    }

    public Turma update(TurmaDTO turmaDTO, Long id){
        Turma turma = new Turma();
        turma.setId(id);
        turma.setSala(turmaDTO.getSala());
        turma.setCodigo(turmaDTO.getCodigo());
        turma.setAno(turmaDTO.getAno());
        turma.setListMaterias(this.materiaService.saveAll(this.parseListIdMateriastoMaterias(turmaDTO.getIdMaterias())));
        turma.setListAlunos(this.alunoService.saveAll(this.parseListIdAlunostoAlunos(turmaDTO.getIdAlunos())));

        return this.iTurmaRepository.save(turma);
    }


    public void deleteById(Long id){
        this.iTurmaRepository.deleteById(id);
    }

    public Turma findById(Long id){
        Optional<Turma> turmaOptional = this.iTurmaRepository.findById(id);

        if(turmaOptional.isPresent()){
            return turmaOptional.get();
        }
        throw new ObjectNotFoundException(Professor.class, "Turma não localizada.");

    }

    public List<Turma> findAll(){
        return this.iTurmaRepository.findAll();
    }

    public List<Aluno> parseListIdAlunostoAlunos(List<Long> listIdAlunos){
        List<Aluno> alunos = new ArrayList<>();

        listIdAlunos.forEach(listIdAluno -> {
            try {
                Aluno aluno = this.alunoService.findById((listIdAluno));
                alunos.add(aluno);
            } catch (Exception ex){
                ex.printStackTrace();
            }
        });

        return alunos;
    }

    public List<Materia> parseListIdMateriastoMaterias(List<Long> listIdMaterias){
        List<Materia> materias = new ArrayList<>();

        listIdMaterias.forEach(listIdMateria -> {
            try {
                Materia materia = this.materiaService.findById((listIdMateria));
                materias.add(materia);
            } catch (Exception ex){

            }
        });

        return materias;
    }

}