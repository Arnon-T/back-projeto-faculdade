package com.faculdade.faculdade.boletim;

import com.faculdade.faculdade.jasperutils.GenerateReport;
import com.faculdade.faculdade.nota.NotaNaoEncontradaException;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("api/boletim")
@CrossOrigin(origins = "*")
public class BoletimController {

    private final BoletimService boletimService;
    private final GenerateReport generateReport;

    @Autowired
    public BoletimController(BoletimService boletimService, GenerateReport generateReport) {
        this.boletimService = boletimService;
        this.generateReport = generateReport;
    }

    @PostMapping("/gerar/{id}/{ano}")
    public Boletim generate(@PathVariable("id") Long id, @PathVariable("ano") String ano) throws NotaNaoEncontradaException, InvalidListNotasException {
        return this.boletimService.generate(id, ano);
    }

    @GetMapping("/export/{aluno}/{ano}")
    public void export(@PathVariable("aluno") String aluno, @PathVariable("ano") String ano, HttpServletResponse response) throws IOException, JRException {
        this.generateReport.exportReport(aluno, ano, response);
    }

    @GetMapping("/{idAluno}")
    public Boletim buscaporaluno(@PathVariable("idAluno") Long idAluno) throws BoletimNaoEncontradoException {
        return this.boletimService.findByAlunoId(idAluno);
    }

    @DeleteMapping("deletar/{idAluno}/{ano}")
    public String deleteBoletim(@PathVariable("idAluno") Long idAluno, @PathVariable("ano") String ano){
        this.boletimService.deleteBoletim(idAluno, ano);
        return "Deletado boletim de aluno-id " + idAluno;
    }
}
