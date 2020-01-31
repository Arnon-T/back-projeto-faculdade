package com.faculdade.faculdade.materia;

public class MateriaDTO {

    private Long id;
    private Long idProfessor;
    private String nome;
    private String descricao;

    public MateriaDTO() {
    }

    public MateriaDTO(Long idProfessor, String nome, String descricao) {
        this.idProfessor = idProfessor;
        this.nome = nome;
        this.descricao = descricao;
    }

    public MateriaDTO(Long id, Long idProfessor, String nome, String descricao) {
        this.id = id;
        this.idProfessor = idProfessor;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static MateriaDTO of(Materia materia){
        return new MateriaDTO(
                materia.getId(),
                materia.getProfessor().getId(),
                materia.getNome(),
                materia.getDescricao()
        );
    }

}
