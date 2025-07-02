package ifsc.jvgc.model.requerimento.estados;

import ifsc.jvgc.model.requerimento.Requerimento;

public class Deferido implements EstadoRequerimento {
    public void avaliar(Requerimento requerimento, boolean deferido) {
        System.out.println("Requerimento já deferido. Nenhuma ação.");
    }

    @Override
    public String nome() {
        return "Deferido";
    }
}
