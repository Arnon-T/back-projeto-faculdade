package com.faculdade.faculdade.boletim;

import com.faculdade.faculdade.aluno.Aluno;
import com.faculdade.faculdade.aluno.AlunoService;
import com.faculdade.faculdade.boletimmodel.BoletimModel;
import com.faculdade.faculdade.boletimmodel.BoletimModelService;
import com.faculdade.faculdade.materia.Materia;
import com.faculdade.faculdade.materia.MateriaService;
import com.faculdade.faculdade.nota.Nota;
import com.faculdade.faculdade.nota.NotaNaoEncontradaException;
import com.faculdade.faculdade.nota.NotaService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class BoletimService {

    private static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BoletimService.class);
    private final IBoletimRepository iBoletimRepository;
    private final NotaService notaService;
    private final AlunoService alunoService;
    private final MateriaService materiaService;
    private final BoletimModelService boletimModelService;
    private static DecimalFormat df = new DecimalFormat("0.00");

    @Autowired
    public BoletimService(IBoletimRepository iBoletimRepository, NotaService notaService, AlunoService alunoService, MateriaService materiaService, BoletimModelService boletimModelService) {
        this.iBoletimRepository = iBoletimRepository;
        this.notaService = notaService;
        this.alunoService = alunoService;
        this.materiaService = materiaService;
        this.boletimModelService = boletimModelService;
    }

    @Transactional
    public Boletim save(BoletimDTO boletimDTO) {
        Boletim boletim = new Boletim();
        List<Nota> notaOptional = new ArrayList<>();

        boletimDTO.getIdNotas().forEach(idNota -> notaOptional.add(this.notaService.findById(idNota)));
        boletim.setNotaList(notaOptional);
        boletim.setAluno(this.alunoService.findById(boletimDTO.getIdAluno()));
        boletim.setAno(boletimDTO.getAno());

        return this.iBoletimRepository.save(boletim);
    }

    @Transactional
    public Boletim generate(Long idAluno, String ano) throws InvalidListNotasException, NotaNaoEncontradaException {
        Boletim boletim = new Boletim();
        List<Nota> listNota = this.notaService.findAllByAlunoId(idAluno);

        Aluno aluno = this.alunoService.findById(idAluno);

        boletim.setNotaList(listNota);
        boletim.setAluno(aluno);
        boletim.setAno(ano);
        BoletimDTO boletimDTO = BoletimDTO.of(boletim);

        this.validate(boletimDTO);

        try {
            this.save(boletimDTO);
        } catch (Exception e) {
            LOGGER.info("Não foi possível salvar nota");
            LOGGER.debug("Error -> []", e);
        }

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
                media += nota.getValorNota();
                notaSeparada[j] = nota.getValorNota();
                j++;
            }
            boletimModel.setNota1(String.valueOf(notaSeparada[0]));
            boletimModel.setNota2(String.valueOf(notaSeparada[1]));
            boletimModel.setNota3(String.valueOf(notaSeparada[2]));
            boletimModel.setNota4(String.valueOf(notaSeparada[3]));
            boletimModel.setMedia(String.valueOf(df.format(media / 4)));

            listModel.add(boletimModel);
        }
        this.boletimModelService.saveAll(listModel);

        return boletim;
    }

    @Transactional
    public void deleteBoletim(Long idAluno, String ano) {
        Aluno aluno = this.alunoService.findById(idAluno);
        this.boletimModelService.deleteAllByNomeAndAno(aluno.getNome(), ano);
        this.iBoletimRepository.deleteAllByAluno_Id(idAluno);
    }

    public Boletim findByAlunoId(Long idAluno) throws BoletimNaoEncontradoException {
        return this.iBoletimRepository.findByAluno_Id(idAluno).orElseThrow(() -> new BoletimNaoEncontradoException("Boletim do aluno de ID: " + idAluno + " nao encontrado."));
    }

    private void validate(BoletimDTO boletimDTO) throws InvalidListNotasException {
        LOGGER.info("Validando boletim.");

        if (boletimDTO.getIdNotas().size() != 28) {
            throw new InvalidListNotasException("Todas as notas devem estar cadastradas.");
        }
        if (StringUtils.isEmpty(String.valueOf(boletimDTO.getIdAluno()))) {
            throw new IllegalArgumentException("Aluno não pode ser nulo.");
        }
        if (StringUtils.isEmpty(boletimDTO.getAno())) {
            throw new IllegalArgumentException("Ano não pode ser nulo.");
        }

    }

}
