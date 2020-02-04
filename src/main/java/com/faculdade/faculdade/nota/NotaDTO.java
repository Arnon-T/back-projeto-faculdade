package com.faculdade.faculdade.nota;

import com.faculdade.faculdade.aluno.Aluno;
import com.faculdade.faculdade.materia.Materia;
import com.faculdade.faculdade.professor.Professor;

public class NotaDTO {

    Long id;
    private Long idAluno;
    private Long idMateria;
    private String avaliacao;
    private double nota;

    public NotaDTO() {
    }

    public NotaDTO(Long idAluno, Long idMateria, String avaliacao, double nota) {
        this.idAluno = idAluno;
        this.idMateria = idMateria;
        this.avaliacao = avaliacao;
        this.nota = nota;
    }

    public NotaDTO(Long id, Long idAluno, Long idMateria, String avaliacao, double nota) {
        this.id = id;
        this.idAluno = idAluno;
        this.idMateria = idMateria;
        this.avaliacao = avaliacao;
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public Long getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(Long idMateria) {
        this.idMateria = idMateria;
    }

    public String getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao) {
        this.avaliacao = avaliacao;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public static NotaDTO of(Nota nota){
        return new NotaDTO(
                nota.getId(),
                nota.getAluno().getId(),
                nota.getMateria().getId(),
                nota.getAvaliacao(),
                nota.getNota()
        );
    }
}
