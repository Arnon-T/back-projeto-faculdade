package com.faculdade.faculdade.faculdade;

import org.hibernate.ObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FaculdadeService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FaculdadeService.class);
    private final IFaculdadeRepository iFaculdadeRepository;

    @Autowired
    public FaculdadeService(IFaculdadeRepository iFaculdadeRepository) { this.iFaculdadeRepository = iFaculdadeRepository; }

    public Faculdade save(FaculdadeDTO faculdadeDTO){
        return this.iFaculdadeRepository.save(new Faculdade(faculdadeDTO.getCnpj(), faculdadeDTO.getRazaoSocial(), faculdadeDTO.getEndereco(), faculdadeDTO.getTelefone()));
    }

    public Faculdade update(FaculdadeDTO faculdadeDTO, Long id){
        Faculdade faculdade = new Faculdade();
        faculdade.setId(id);
        faculdade.setCnpj(faculdadeDTO.getCnpj());
        faculdade.setRazaoSocial(faculdadeDTO.getRazaoSocial());
        faculdade.setEndereco(faculdadeDTO.getEndereco());
        faculdade.setTelefone(faculdadeDTO.getTelefone());

        return this.iFaculdadeRepository.save(faculdade);
    }

    public void deleteById(Long id){
        this.iFaculdadeRepository.deleteById(id);
    }

    public Faculdade findById(Long id){
        Optional<Faculdade> faculdadeOptional = this.iFaculdadeRepository.findById(id);

        if(faculdadeOptional.isPresent()){
            return faculdadeOptional.get();
        }
        throw new ObjectNotFoundException(Faculdade.class, "Faculdade não localizada.");

    }

    public List<Faculdade> findAll(){
        return this.iFaculdadeRepository.findAll();
    }
}
