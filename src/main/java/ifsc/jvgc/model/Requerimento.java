package ifsc.jvgc.model;

import ifsc.jvgc.state.EmAberto;
import ifsc.jvgc.state.EstadoRequerimento;

import java.time.LocalDate;

public class Requerimento {
    private final int id;
    private final Aluno aluno;
    private final LocalDate dataRequerimento;
    private final LocalDate dataValidacao;
    private EstadoRequerimento estado;

    public Requerimento(int id, Aluno aluno, LocalDate dataRequerimento, LocalDate dataValidacao) {
        this.id = id;
        this.aluno = aluno;
        this.dataRequerimento = dataRequerimento;
        this.dataValidacao = dataValidacao;
        this.estado = new EmAberto();
    }

    @Override
    public String toString() {
        return "Requerimento{id=" + id + ", aluno=" + aluno + ", estado='" + estado.nome() + "'}";
    }

    public void avaliar() {
        estado.avaliar(this);
    }

    public void setEstado(EstadoRequerimento estado) {
        this.estado = estado;
    }
}
