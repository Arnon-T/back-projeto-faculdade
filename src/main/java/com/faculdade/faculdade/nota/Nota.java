package com.faculdade.faculdade.nota;

import com.faculdade.faculdade.aluno.Aluno;
import com.faculdade.faculdade.materia.Materia;
import com.faculdade.faculdade.professor.Professor;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "nota")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "id_aluno", referencedColumnName = "id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_materia", referencedColumnName = "id")
    private Materia materia;

    @Column(name = "avaliacao")
    private String avaliacao;

    @Column(name = "nota")
    private double nota;


    public Nota() {
    }

    public Nota(Aluno aluno, Materia materia, String avaliacao, double nota) {
        this.aluno = aluno;
        this.materia = materia;
        this.avaliacao = avaliacao;
        this.nota = nota;
    }

    public Nota(Long id, Aluno aluno, Materia materia, String avaliacao, double nota) {
        this.id = id;
        this.aluno = aluno;
        this.materia = materia;
        this.avaliacao = avaliacao;
        this.nota = nota;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
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
}
