package com.faculdade.faculdade.turma;

import com.faculdade.faculdade.aluno.Aluno;
import com.faculdade.faculdade.materia.Materia;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

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

    @ManyToMany
    @JoinTable(name = "turma_aluno", joinColumns = {@JoinColumn(name = "id_turma")}, inverseJoinColumns = {@JoinColumn(name = "id_aluno")})
    private List<Aluno> listAlunos;

    @ManyToMany
    @JoinTable(name = "turma_materia", joinColumns = @JoinColumn(name = "id_turma"), inverseJoinColumns = @JoinColumn(name = "id_materia"))
    private List<Materia> listMaterias;

    public Turma() {
    }

    public Turma(String sala, String codigo, LocalDate ano, List<Aluno> aluno, List<Materia> materia) {
        this.sala = sala;
        this.codigo = codigo;
        this.ano = ano;
        this.listAlunos = aluno;
        this.listMaterias = materia;
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

    public List<Aluno> getListAlunos() {
        return listAlunos;
    }

    public void setListAlunos(List<Aluno> listAlunos) {
        this.listAlunos = listAlunos;
    }

    public List<Materia> getListMaterias() {
        return listMaterias;
    }

    public void setListMaterias(List<Materia> listMaterias) {
        this.listMaterias = listMaterias;
    }
}
