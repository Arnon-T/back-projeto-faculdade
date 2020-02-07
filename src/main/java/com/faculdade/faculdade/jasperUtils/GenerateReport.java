package com.faculdade.faculdade.jasperUtils;

import com.faculdade.faculdade.boletimModel.BoletimModel;
import com.faculdade.faculdade.boletimModel.BoletimModelService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GenerateReport {

    private BoletimModelService boletimModelService;

    public GenerateReport(BoletimModelService boletimModelService) {
        this.boletimModelService = boletimModelService;
    }

    public String exportReport(String aluno, String ano, HttpServletResponse response) throws FileNotFoundException, JRException {
        List<BoletimModel> listBoletim = this.boletimModelService.findAllByAlunoAndAno(aluno, ano);

        response.setContentType("text/csv");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + "boletim" + "\"" + ".pdf");

        File file = ResourceUtils.getFile("classpath:boletim.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listBoletim);
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("createdBy", "Arnon");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);


        return "Relatório gerado no diretório C:\\Users\\arnon.silva\\Downloads\\boletim.pdf:";
}
}
