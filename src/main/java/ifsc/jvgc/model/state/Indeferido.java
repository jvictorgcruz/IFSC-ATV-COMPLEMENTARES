package ifsc.jvgc.model.state;

import ifsc.jvgc.model.entities.Requerimento;

public class Indeferido implements EstadoRequerimento {
    public void avaliar(Requerimento requerimento, boolean deferido) {
        System.out.println("Requerimento indeferido. Encerrado.");
    }

    @Override
    public String nome() {
        return "Indeferido";
    }
}
