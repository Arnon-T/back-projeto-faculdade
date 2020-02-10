package com.faculdade.faculdade.boletim;

import com.faculdade.faculdade.aluno.Aluno;
import com.faculdade.faculdade.nota.Nota;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "boletim")
public class Boletim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToMany
    @JoinTable(name = "boletim_nota", joinColumns = @JoinColumn(name = "id_boletim"), inverseJoinColumns = @JoinColumn(name = "id_nota"))
    private List<Nota> notaList;

    @ManyToOne
    @JoinColumn(name = "id_aluno", referencedColumnName = "id")
    private Aluno aluno;

    @Column(name = "ano")
    private String ano;


    public Boletim() {
    }

    public Boletim(List<Nota> notaList, Aluno aluno, String ano) {
        this.notaList = notaList;
        this.aluno = aluno;
        this.ano = ano;
    }

    public Boletim(Long id, List<Nota> notaList, Aluno aluno, String ano) {
        this.id = id;
        this.notaList = notaList;
        this.aluno = aluno;
        this.ano = ano;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Nota> getNotaList() {
        return notaList;
    }

    public void setNotaList(List<Nota> notaList) {
        this.notaList = notaList;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
}
