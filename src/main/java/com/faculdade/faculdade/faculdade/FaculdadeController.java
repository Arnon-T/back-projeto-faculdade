package com.faculdade.faculdade.faculdade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/faculdade")
public class FaculdadeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(FaculdadeController.class);
    private final FaculdadeService faculdadeService;

    @Autowired
    public FaculdadeController(FaculdadeService faculdadeService) { this.faculdadeService = faculdadeService; }

    @PostMapping("/cadastrar")
    public FaculdadeDTO save(@RequestBody FaculdadeDTO faculdadeDTO){
        return FaculdadeDTO.of(this.faculdadeService.save(faculdadeDTO));
    }

    @PutMapping("/atualizar/{id}")
    public FaculdadeDTO update(@RequestBody FaculdadeDTO faculdadeDTO, @PathVariable("id") Long id){
        return FaculdadeDTO.of(this.faculdadeService.update(faculdadeDTO, id));
    }

    @DeleteMapping("/deletar/{id}")
    public void delete(@PathVariable("id") Long id){
        this.faculdadeService.deleteById(id);
    }

    @RequestMapping("/selecionar/")
    public List<Faculdade> findAll(){
        return this.faculdadeService.findAll();
    }

    @RequestMapping("/selecionar/{id}")
    public FaculdadeDTO findById(@PathVariable("id") Long id){
        return FaculdadeDTO.of(this.faculdadeService.findById(id));
    }

}

