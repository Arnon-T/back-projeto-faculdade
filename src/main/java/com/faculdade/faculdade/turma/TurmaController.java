package com.faculdade.faculdade.turma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/turma")
public class TurmaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TurmaController.class);
    private final TurmaService turmaService;

    @Autowired
    public TurmaController(TurmaService turmaService) { this.turmaService = turmaService; }

    @PostMapping("/cadastrar")
    public TurmaDTO save(@RequestBody TurmaDTO turmaDTO){
        return TurmaDTO.of(this.turmaService.save(turmaDTO));
    }

    @PutMapping("/atualizar/{id}")
    public TurmaDTO update(@RequestBody TurmaDTO turmaDTO, @PathVariable("id") Long id){
        return TurmaDTO.of(this.turmaService.update(turmaDTO, id));
    }

    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable("id") Long id){
        this.turmaService.deleteById(id);
    }

    @RequestMapping("/selecionar/")
    public List<Turma> findAll(){
        return this.turmaService.findAll();
    }

    @RequestMapping("/selecionar/{id}")
    public TurmaDTO findById(@PathVariable("id") Long id){
        return TurmaDTO.of(this.turmaService.findById(id));
    }

}
