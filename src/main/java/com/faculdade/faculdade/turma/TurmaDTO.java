package com.faculdade.faculdade.turma;

import com.faculdade.faculdade.aluno.Aluno;
import com.faculdade.faculdade.materia.Materia;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class TurmaDTO {

    private Long id;
    private String sala;
    private String codigo;
    private LocalDate ano;
    private List<Long> idAlunos;
    private List<Long> idMaterias;

    public TurmaDTO() {
    }

    public TurmaDTO(String sala, String codigo, LocalDate ano, List<Long> idAluno, List<Long> idMateria) {
        this.sala = sala;
        this.codigo = codigo;
        this.ano = ano;
        this.idAlunos = idAluno;
        this.idMaterias = idMateria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public List<Long> getIdAlunos() {
        return idAlunos;
    }

    public void setIdAlunos(List<Long> idAlunos) {
        this.idAlunos = idAlunos;
    }

    public List<Long> getIdMaterias() {
        return idMaterias;
    }

    public void setIdMaterias(List<Long> idMaterias) {
        this.idMaterias = idMaterias;
    }

    public static TurmaDTO of(Turma turma){
        return new TurmaDTO(
                turma.getSala(),
                turma.getCodigo(),
                turma.getAno(),
                turma.getListAlunos().stream().map(Aluno::getId).collect(Collectors.toList()),
                turma.getListMaterias().stream().map(Materia::getId).collect(Collectors.toList())
        );
    }
}
