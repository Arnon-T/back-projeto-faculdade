package com.faculdade.faculdade.professor;

import com.faculdade.faculdade.materia.Materia;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public class ProfessorDTO {

    private Long id;
    @NotNull
    @NotBlank
    private String nome;
    @NotNull
    private int telefone;
    @Email
    private String email;
    private String endereco;
    private List<Long> listIdMateria;

    public ProfessorDTO() {
    }

    public ProfessorDTO(String nome,int telefone, String email, String endereco, List<Long> listIdMateria) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listIdMateria = listIdMateria;
    }

    public ProfessorDTO(Long id, String nome, int telefone, String email, String endereco, List<Long> listIdMateria) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listIdMateria = listIdMateria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public List<Long> getListIdMateria() {
        return listIdMateria;
    }

    public void setListIdMateria(List<Long> listIdMateria) {
        this.listIdMateria = listIdMateria;
    }

    public static ProfessorDTO of(Professor professor){
        return new ProfessorDTO(
                professor.getId(),
                professor.getNome(),
                professor.getTelefone(),
                professor.getEmail(),
                professor.getEndereco(),
                professor.getMateria().stream().map(Materia::getId).collect(Collectors.toList())
        );
    }
}
