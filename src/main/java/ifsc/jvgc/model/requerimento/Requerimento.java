package ifsc.jvgc.model.requerimento;

import ifsc.jvgc.model.Matricula;
import ifsc.jvgc.model.requerimento.estados.EmAberto;
import ifsc.jvgc.model.requerimento.estados.EstadoRequerimento;

import java.time.LocalDate;

public class Requerimento {
    private int id;
    private final Matricula matricula;
    private final LocalDate dataRequerimento;
    private LocalDate dataValidacao;
    private EstadoRequerimento estado;

    public Requerimento(Matricula matricula, LocalDate dataRequerimento, LocalDate dataValidacao) {
        this.matricula = matricula;
        this.dataRequerimento = dataRequerimento;
        this.dataValidacao = dataValidacao;
        this.estado = new EmAberto();
    }

    public void avaliar(boolean deferido) {
        estado.avaliar(this, deferido);
    }

    public void setEstado(EstadoRequerimento estado) {
        this.estado = estado;
    }

    public void validar() {
        this.dataValidacao = LocalDate.now();
    }

    public String nomeDoEstado(){
        return this.estado.nome();
    }
}
