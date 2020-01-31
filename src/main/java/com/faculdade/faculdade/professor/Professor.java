package com.faculdade.faculdade.professor;

import com.faculdade.faculdade.materia.Materia;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Entity
@Table(name = "professor")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "telefone")
    private int telefone;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "endereco")
    private String endereco;

    @OneToMany
    @JoinTable(name = "turma_materia", joinColumns = {@JoinColumn(name = "id_aluno", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "id", referencedColumnName = "id")})
    private List<Materia> listMateria;

    public Professor() {
    }

    public Professor(String nome, int telefone, String email, String endereco, List<Materia> listMateria) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listMateria = listMateria;
    }

    public Professor(long id, String nome, int telefone, String email, String endereco, List<Materia> listMateria) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.listMateria = listMateria;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<Materia> getListMateria() {
        return listMateria;
    }

    public void setListMateria(List<Materia> listMateria) {
        this.listMateria = listMateria;
    }
}
