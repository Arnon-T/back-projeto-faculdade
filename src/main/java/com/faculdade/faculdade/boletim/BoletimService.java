package com.faculdade.faculdade.boletim;

import com.faculdade.faculdade.aluno.Aluno;
import com.faculdade.faculdade.aluno.AlunoService;
import com.faculdade.faculdade.boletimModel.BoletimModel;
import com.faculdade.faculdade.boletimModel.BoletimModelService;
import com.faculdade.faculdade.jasperUtils.GenerateReport;
import com.faculdade.faculdade.materia.Materia;
import com.faculdade.faculdade.materia.MateriaService;
import com.faculdade.faculdade.nota.Nota;
import com.faculdade.faculdade.nota.NotaService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoletimService {

    private final IBoletimRepository iBoletimRepository;
    private final NotaService notaService;
    private final AlunoService alunoService;
    private final MateriaService materiaService;
    private final BoletimModelService boletimModelService;
    private final GenerateReport generateReport;
    private static DecimalFormat df = new DecimalFormat("0.00");

    @Autowired
    public BoletimService(IBoletimRepository iBoletimRepository, NotaService notaService, AlunoService alunoService, MateriaService materiaService, BoletimModelService boletimModelService, GenerateReport generateReport) {
        this.iBoletimRepository = iBoletimRepository;
        this.notaService = notaService;
        this.alunoService = alunoService;
        this.materiaService = materiaService;
        this.boletimModelService = boletimModelService;
        this.generateReport = generateReport;
    }

    @Transactional
    public Boletim save(BoletimDTO boletimDTO){
        Boletim boletim = new Boletim();
        List<Nota> notaOptional = new ArrayList<>();

        boletimDTO.getIdNotas().forEach(idNota -> notaOptional.add(this.notaService.findById(idNota)));
        boletim.setNotaList(notaOptional);
        boletim.setAluno(this.alunoService.findById(boletimDTO.getIdAluno()));

        return this.iBoletimRepository.save(boletim);
    }

    public Boletim generate(Long idAluno, String ano) throws FileNotFoundException, JRException {
        Boletim boletim = new Boletim();
        List<Nota> listNota = this.notaService.findAllByAlunoId(idAluno);
        Aluno aluno = this.alunoService.findById(idAluno);
        boletim.setNotaList(listNota);
        boletim.setAluno(aluno);
        BoletimDTO boletimDTO = BoletimDTO.of(boletim);
        save(boletimDTO);

        List<BoletimModel> listModel = new ArrayList<>();
        List<Materia> materias = this.materiaService.findAll();
        for (Materia materia : materias) {
            BoletimModel boletimModel = new BoletimModel();

            List<Nota> notas = this.notaService.findAllByAlunoIdAndMateriaId(idAluno, materia.getId());

            boletimModel.setAluno(aluno.getNome());
            boletimModel.setAno(String.valueOf(LocalDate.now().getYear()));
            boletimModel.setMateria(materia.getNome());
            double media = 0;
            double[] notaSeparada = new double[4];
            int j = 0;
            for (Nota nota : notas) {
                media += nota.getNota();
                notaSeparada[j] = nota.getNota();
                j++;
            }
            boletimModel.setNota1(String.valueOf(notaSeparada[0]));
            boletimModel.setNota2(String.valueOf(notaSeparada[1]));
            boletimModel.setNota3(String.valueOf(notaSeparada[2]));
            boletimModel.setNota4(String.valueOf(notaSeparada[3]));
            boletimModel.setMedia(String.valueOf(df.format(media/4)));

            listModel.add(boletimModel);
        }
        this.boletimModelService.saveAll(listModel);
        return boletim;
    }

    public void deleteBoletim(Long idAluno, String ano){
        Aluno aluno = this.alunoService.findById(idAluno);
        this.boletimModelService.deleteAllByNomeAndAno(aluno.getNome(), ano);
        this.iBoletimRepository.deleteAllByAluno_Id(idAluno);
    }

    public Boletim findByAlunoId(Long idAluno){
        return this.iBoletimRepository.findByAluno_Id(idAluno);
    }


}
