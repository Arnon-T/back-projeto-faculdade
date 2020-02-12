package com.faculdade.faculdade.jasperutils;

import com.faculdade.faculdade.boletimmodel.BoletimModel;
import com.faculdade.faculdade.boletimmodel.BoletimModelService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GenerateReport {

    private BoletimModelService boletimModelService;

    public GenerateReport(BoletimModelService boletimModelService) {
        this.boletimModelService = boletimModelService;
    }

    public void exportReport(String aluno, String ano, HttpServletResponse response) throws IOException, JRException {
        List<BoletimModel> listBoletim = this.boletimModelService.findAllByAlunoAndAno(aluno, ano);

        response.setContentType("application/pdf");
        response.setHeader(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + "boletim" + "\"");
        OutputStream out = response.getOutputStream();
        File file = ResourceUtils.getFile("classpath:boletim.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());

        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listBoletim);
        Map<String, Object> parameters = new HashMap<>();

        parameters.put("createdBy", "Arnon");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

        JasperExportManager.exportReportToPdfStream(jasperPrint, out);
}
}
