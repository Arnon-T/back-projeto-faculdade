package com.faculdade.faculdade.aluno;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/aluno")
@CrossOrigin(origins = "*")
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

    @GetMapping("/selecionar/")
    public List<Aluno> findAll(){
        return this.alunoService.findAll();
    }

    @GetMapping("/selecionar/{id}")
    public AlunoDTO findById(@PathVariable("id") Long id){
        return AlunoDTO.of(this.alunoService.findById(id));
    }

    @GetMapping("selecionar/busca/{nome}")
    public List<Aluno> findAllLike(@PathVariable("nome") String nome){
        List<Aluno> alunos = this.alunoService.findAllLike(nome);
        return this.alunoService.findAllLike(nome);
    }

}
