package com.faculdade.faculdade.aluno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/aluno")
public class AlunoController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlunoController.class);
    private final AlunoService alunoService;

    @Autowired
    public AlunoController(AlunoService alunoService) { this.alunoService = alunoService; }

    @PostMapping("/cadastrar")
    public AlunoDTO save(@RequestBody AlunoDTO alunoDTO){
        return AlunoDTO.of(this.alunoService.save(alunoDTO));
    }

    @PutMapping("/atualizar/{id}")
    public AlunoDTO update(@RequestBody AlunoDTO alunoDTO, @PathVariable("id") Long id){
        return AlunoDTO.of(this.alunoService.update(alunoDTO, id));
    }

    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable("id") Long id){
        this.alunoService.deleteById(id);
    }

    @RequestMapping("/selecionar/")
    public List<Aluno> findAll(){
        return this.alunoService.findAll();
    }

    @RequestMapping("/selecionar/{id}")
    public AlunoDTO findById(@PathVariable("id") Long id){
        return AlunoDTO.of(this.alunoService.findById(id));
    }

}
