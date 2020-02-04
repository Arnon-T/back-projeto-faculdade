package com.faculdade.faculdade.materia;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/materia")
public class MateriaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(MateriaController.class);
    private final MateriaService materiaService;

    @Autowired
    public MateriaController(MateriaService materiaService) { this.materiaService = materiaService; }

    @PostMapping("/cadastrar")
    public MateriaDTO save(@RequestBody MateriaDTO materiaDTO){
        return MateriaDTO.of(this.materiaService.save(materiaDTO));
    }

    @PutMapping("/atualizar/{id}")
    public MateriaDTO update(@RequestBody MateriaDTO materiaDTO, @PathVariable("id") Long id){
        return MateriaDTO.of(this.materiaService.update(materiaDTO, id));
    }

    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable("id") Long id){
        this.materiaService.deleteById(id);
    }

    @RequestMapping("/selecionar/")
    public List<Materia> findAll(){
        return this.materiaService.findAll();
    }

    @RequestMapping("/selecionar/{id}")
    public MateriaDTO findById(@PathVariable("id") Long id){
        return MateriaDTO.of(this.materiaService.findById(id));
    }

}

