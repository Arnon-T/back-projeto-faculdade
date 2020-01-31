package com.faculdade.faculdade.faculdade;

import org.hibernate.validator.constraints.br.CNPJ;
import javax.validation.constraints.NotNull;

public class FaculdadeDTO {

    private long id;
    @CNPJ
    @NotNull(message = "O CNPJ não deve ser nulo.")
    private int cnpj;
    @NotNull(message = "A razão social não deve ser nula.")
    private String razaoSocial;
    @NotNull(message = "O endereço não deve ser nulo.")
    private String endereco;
    @NotNull(message = "O telefone não deve ser nulo.")
    private int telefone;

    public FaculdadeDTO() {
    }

    public FaculdadeDTO(int cnpj, String razaoSocial, String endereco, int telefone) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public FaculdadeDTO(long id, int cnpj, String razaoSocial, String endereco, int telefone) {
        this.id = id;
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public static FaculdadeDTO of(Faculdade faculdade){
        return new FaculdadeDTO(
        faculdade.getId(),
        faculdade.getCnpj(),
        faculdade.getRazaoSocial(),
        faculdade.getEndereco(),
        faculdade.getTelefone());
    }
}
