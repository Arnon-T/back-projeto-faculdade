package com.faculdade.faculdade.nota;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/nota")
@CrossOrigin(origins = "*")
public class NotaController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NotaController.class);
    private final NotaService notaService;

    @Autowired
    public NotaController(NotaService notaService) { this.notaService = notaService; }

    @PostMapping("/cadastrar")
    public NotaDTO save(@RequestBody NotaDTO notaDTO){
        return NotaDTO.of(this.notaService.save(notaDTO));
    }

    @PutMapping("/atualizar/{id}")
    public NotaDTO update(@RequestBody NotaDTO notaDTO, @PathVariable("id") Long id){
        return NotaDTO.of(this.notaService.update(notaDTO, id));
    }

    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable("id") Long id){
        this.notaService.deleteById(id);
    }

    @GetMapping("/selecionar/")
    public List<Nota> findAll(){
        return this.notaService.findAll();
    }

    @GetMapping("/selecionar/todos/{id}")
    public List<Nota> findAllByAlunoId(@PathVariable("id") Long id){
        return this.notaService.findAllByAlunoId(id);
    }

    @GetMapping("/selecionar/{id}")
    public Nota findById(@PathVariable("id") Long id){
        return this.notaService.findById(id);
    }


}
