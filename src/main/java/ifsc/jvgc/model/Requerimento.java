package ifsc.jvgc.model;

import ifsc.jvgc.state.EmAberto;
import ifsc.jvgc.state.EstadoRequerimento;

import java.time.LocalDate;

public class Requerimento {
    private int id;
    private final Aluno aluno;
    private final LocalDate dataRequerimento;
    private LocalDate dataValidacao;
    private EstadoRequerimento estado;

    public Requerimento(Aluno aluno, LocalDate dataRequerimento, LocalDate dataValidacao) {
        this.aluno = aluno;
        this.dataRequerimento = dataRequerimento;
        this.dataValidacao = dataValidacao;
        this.estado = new EmAberto();
    }

    public void avaliar() {
        estado.avaliar(this);
    }

    public void setEstado(EstadoRequerimento estado) {
        this.estado = estado;
    }

    public void validar() {
        this.dataValidacao = LocalDate.now();
    }
}
