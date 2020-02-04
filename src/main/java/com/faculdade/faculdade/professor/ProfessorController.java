package com.faculdade.faculdade.professor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/professor")
public class ProfessorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProfessorController.class);
    private final ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) { this.professorService = professorService; }

    @PostMapping("/cadastrar")
    public ProfessorDTO save(@RequestBody ProfessorDTO professorDTO){
        return ProfessorDTO.of(this.professorService.save(professorDTO));
    }

    @PutMapping("/atualizar/{id}")
    public ProfessorDTO update(@RequestBody ProfessorDTO professorDTO, @PathVariable("id") Long id){
        return ProfessorDTO.of(this.professorService.update(professorDTO, id));
    }

    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable("id") Long id){
        this.professorService.deleteById(id);
    }

    @RequestMapping("/selecionar/")
    public List<Professor> findAll(){
        return this.professorService.findAll();
    }

    @RequestMapping("/selecionar/{id}")
    public ProfessorDTO findById(@PathVariable("id") Long id){
        return ProfessorDTO.of(this.professorService.findById(id));
    }

}
