package ifsc.jvgc.model.requerimento.estados;

import ifsc.jvgc.model.requerimento.Requerimento;

public class Indeferido implements EstadoRequerimento {
    public void avaliar(Requerimento requerimento, boolean deferido) {
        System.out.println("Requerimento indeferido. Encerrado.");
    }

    @Override
    public String nome() {
        return "Indeferido";
    }
}
