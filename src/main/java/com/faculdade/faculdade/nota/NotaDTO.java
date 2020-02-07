package com.faculdade.faculdade.nota;

public class NotaDTO {

    Long id;
    private Long idAluno;
    private Long idMateria;
    private String trimestre;
    private double nota;

    public NotaDTO() {
    }

    public NotaDTO(Long idAluno, Long idMateria, String trimestre, double nota) {
        this.idAluno = idAluno;
        this.idMateria = idMateria;
        this.trimestre = trimestre;
        this.nota = nota;
    }

    public NotaDTO(Long id, Long idAluno, Long idMateria, String trimestre, double nota) {
        this.id = id;
        this.idAluno = idAluno;
        this.idMateria = idMateria;
        this.trimestre = trimestre;
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

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
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
                nota.getTrimestre().getDescricao(),
                nota.getNota()
        );
    }
}
