package com.faculdade.faculdade.aluno;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AlunoDTO {

    private Long id;
    @NotNull(message = "O nome não deve ser nulo.")
    private String nome;
    @NotNull(message = "O telefone não deve ser nulo.")
    @Size(min = 10, message = "Digite um telefone válido, com DDD.")
    private int telefone;
    @Email
    private String email;
    @NotNull(message = "O endereco não deve ser nulo.")
    @NotBlank(message = "O endereco não pode estar em branco.")
    private String endereco;

    public AlunoDTO() {
    }

    public AlunoDTO(String nome, int telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
    }

    public AlunoDTO(Long id, String nome, int telefone, String email, String endereco) {
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
