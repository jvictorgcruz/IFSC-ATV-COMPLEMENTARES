package ifsc.jvgc.model;

import java.time.LocalDate;

public class Requerimento {
    private final int id;
    private final Aluno aluno;
    private final LocalDate dataRequerimento;
    private final String status;
    private final LocalDate dataValidacao;

    public Requerimento(int id, Aluno aluno, LocalDate dataRequerimento, String status, LocalDate dataValidacao) {
        this.id = id;
        this.aluno = aluno;
        this.dataRequerimento = dataRequerimento;
        this.status = status;
        this.dataValidacao = dataValidacao;
    }

    @Override
    public String toString() {
        return "Requerimento{id=" + id + ", aluno=" + aluno + ", status='" + status + "'}";
    }
}
