package com.faculdade.faculdade.boletim;

import java.util.ArrayList;
import java.util.List;

public class BoletimDTO {

    private Long id;

    private List<Long> idNotas;

    private Long idAluno;

    public BoletimDTO() {
    }

    public BoletimDTO(List<Long> idNotas, Long idAluno) {
        this.idNotas = idNotas;
        this.idAluno = idAluno;
    }

    public BoletimDTO(Long id, List<Long> idNotas, Long idAluno) {
        this.id = id;
        this.idNotas = idNotas;
        this.idAluno = idAluno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getIdNotas() {
        return idNotas;
    }

    public void setIdNotas(List<Long> idNotas) {
        this.idNotas = idNotas;
    }

    public Long getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(Long idAluno) {
        this.idAluno = idAluno;
    }

    public static BoletimDTO of(Boletim boletim){
        List<Long> listIdNota = new ArrayList<>();

        boletim.getNotaList().forEach(nota -> listIdNota.add(nota.getId()));
        return new BoletimDTO(
                listIdNota,
                boletim.getAluno().getId()
        );
    }
}
