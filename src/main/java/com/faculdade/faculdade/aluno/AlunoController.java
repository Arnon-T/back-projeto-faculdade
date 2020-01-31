package com.faculdade.faculdade.aluno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/alunos")
public class AlunoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoController.class);
    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) { this.alunoService = alunoService; }

}
