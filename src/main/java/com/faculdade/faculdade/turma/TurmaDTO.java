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
    private List<Long> idAluno;
    private List<Long> idMateria;

    public TurmaDTO() {
    }

    public TurmaDTO(String sala, String codigo, LocalDate ano, List<Long> idAluno, List<Long> idMateria) {
        this.sala = sala;
        this.codigo = codigo;
        this.ano = ano;
        this.idAluno = idAluno;
        this.idMateria = idMateria;
    }

    public TurmaDTO(Long id, String sala, String codigo, LocalDate ano, List<Long> idAluno, List<Long> idMateria) {
        this.id = id;
        this.sala = sala;
        this.codigo = codigo;
        this.ano = ano;
        this.idAluno = idAluno;
        this.idMateria = idMateria;
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

    public List<Long> getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(List<Long> idAluno) {
        this.idAluno = idAluno;
    }

    public List<Long> getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(List<Long> idMateria) {
        this.idMateria = idMateria;
    }

    public static TurmaDTO of(Turma turma){
        return new TurmaDTO(
                turma.getId(),
                turma.getSala(),
                turma.getCodigo(),
                turma.getAno(),
                turma.getAluno().stream().map(Aluno::getId).collect(Collectors.toList()),
                turma.getMateria().stream().map(Materia::getId).collect(Collectors.toList())
        );
    }
}
