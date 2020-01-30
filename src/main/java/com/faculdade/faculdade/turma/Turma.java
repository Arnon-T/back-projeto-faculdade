package com.faculdade.faculdade.turma;

import com.faculdade.faculdade.aluno.Aluno;
import com.faculdade.faculdade.materia.Materia;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "turma")
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "sala")
    private String sala;

    @Column(name = "codigo")
    private String codigo;

    @Column(name = "ano")
    private LocalDate ano;

    @ManyToOne
    @JoinColumn(name = "id_aluno")
    private Aluno aluno;

    @ManyToMany
    @JoinTable(name = "turma_materia", joinColumns = @JoinColumn(name = "turma_id"), inverseJoinColumns = @JoinColumn(name = "materia_id"))
    private Set<Materia> materia = new HashSet<>();

    public Turma() {
    }

    public Turma(long id, String sala, String codigo, LocalDate ano, Aluno aluno, Set<Materia> materia) {
        this.id = id;
        this.sala = sala;
        this.codigo = codigo;
        this.ano = ano;
        this.aluno = aluno;
        this.materia = materia;
    }

    public Turma(String sala, String codigo, LocalDate ano, Aluno aluno, Set<Materia> materia) {
        this.sala = sala;
        this.codigo = codigo;
        this.ano = ano;
        this.aluno = aluno;
        this.materia = materia;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public LocalDate getAno() {
        return ano;
    }

    public void setAno(LocalDate ano) {
        this.ano = ano;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Set<Materia> getMateria() {
        return materia;
    }

    public void setMateria(Set<Materia> materia) {
        this.materia = materia;
    }
}