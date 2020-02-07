package com.faculdade.faculdade.boletimModel;

import javax.persistence.*;

@Entity
public class BoletimModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "aluno")
    private String aluno;

    @Column(name = "ano")
    private String ano;

    @Column(name = "materia")
    private String materia;

    @Column(name = "nota1")
    private String nota1;

    @Column(name = "nota2")
    private String nota2;

    @Column(name = "nota3")
    private String nota3;

    @Column(name = "nota4")
    private String nota4;

    @Column(name = "media")
    private String media;

    public BoletimModel() {
    }

    public BoletimModel(String aluno, String ano, String materia, String nota1, String nota2, String nota3, String nota4, String media) {
        this.aluno = aluno;
        this.ano = ano;
        this.materia = materia;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.nota4 = nota4;
        this.media = media;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAluno() {
        return aluno;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getNota1() {
        return nota1;
    }

    public void setNota1(String nota1) {
        this.nota1 = nota1;
    }

    public String getNota2() {
        return nota2;
    }

    public void setNota2(String nota2) {
        this.nota2 = nota2;
    }

    public String getNota3() {
        return nota3;
    }

    public void setNota3(String nota3) {
        this.nota3 = nota3;
    }

    public String getNota4() {
        return nota4;
    }

    public void setNota4(String nota4) {
        this.nota4 = nota4;
    }

    public String getMedia() {
        return media;
    }

    public void setMedia(String media) {
        this.media = media;
    }

}
