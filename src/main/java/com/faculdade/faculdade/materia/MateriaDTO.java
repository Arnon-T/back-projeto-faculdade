package com.faculdade.faculdade.materia;

public class MateriaDTO {

    private Long id;
    private String nome;

    public MateriaDTO() {
    }

    public MateriaDTO(String nome) {
        this.nome = nome;
    }

    public MateriaDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static MateriaDTO of(Materia materia){
        return new MateriaDTO(
                materia.getId(),
                materia.getNome()
        );
    }

}
