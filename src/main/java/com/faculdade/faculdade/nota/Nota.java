package com.faculdade.faculdade.nota;

import com.faculdade.faculdade.aluno.Aluno;
import com.faculdade.faculdade.materia.Materia;

import javax.persistence.*;

@Entity
@Table(name = "nota")
public class Nota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_aluno", referencedColumnName = "id")
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "id_materia", referencedColumnName = "id")
    private Materia materia;

    @Enumerated(EnumType.STRING)
    @Column(name = "trimeste")
    private TrimestreNota trimestre;

    @Column(name = "nota")
    private double valorNota;


    public Nota() {
    }

    public Nota(Aluno aluno, Materia materia, TrimestreNota trimestre, double valorNota) {
        this.aluno = aluno;
        this.materia = materia;
        this.trimestre = trimestre;
        this.valorNota = valorNota;
    }

    public Nota(Long id, Aluno aluno, Materia materia, TrimestreNota trimestre, double valorNota) {
        this.id = id;
        this.aluno = aluno;
        this.materia = materia;
        this.trimestre = trimestre;
        this.valorNota = valorNota;
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

    public TrimestreNota getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(TrimestreNota trimestre) {
        this.trimestre = trimestre;
    }

    public double getValorNota() {
        return valorNota;
    }

    public void setValorNota(double valorNota) {
        this.valorNota = valorNota;
    }
}
