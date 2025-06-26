package ifsc.jvgc.state;

import ifsc.jvgc.model.Requerimento;

public class Indeferido implements EstadoRequerimento {
    public void avaliar(Requerimento requerimento) {
        System.out.println("Requerimento indeferido. Encerrado.");
    }

    @Override
    public String nome() {
        return "Indeferido";
    }
}
