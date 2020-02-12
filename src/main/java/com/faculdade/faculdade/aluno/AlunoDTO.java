package com.faculdade.faculdade.aluno;

import javax.validation.constraints.Email;

public class AlunoDTO {

    private Long id;
    private String nome;
    private long telefone;
    @Email
    private String email;
    private String endereco;

    public AlunoDTO() {
    }

    public AlunoDTO(String nome, long telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public AlunoDTO(Long id, String nome, long telefone, String email, String endereco) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
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

    public long getTelefone() {
        return telefone;
    }

    public void setTelefone(long telefone) {
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

    public static AlunoDTO of(Aluno aluno){
        AlunoDTO alunoDTO = new AlunoDTO();
        alunoDTO.setId(aluno.getId());
        alunoDTO.setNome(aluno.getNome());
        alunoDTO.setTelefone(aluno.getTelefone());
        alunoDTO.setEmail(aluno.getEmail());
        alunoDTO.setEndereco(aluno.getEndereco());
        return alunoDTO;
    }

}
