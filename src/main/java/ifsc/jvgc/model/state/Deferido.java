package ifsc.jvgc.model.state;

import ifsc.jvgc.model.entities.Requerimento;

public class Deferido implements EstadoRequerimento {
    public void avaliar(Requerimento requerimento) {
        System.out.println("Requerimento já deferido. Nenhuma ação.");
    }

    @Override
    public String nome() {
        return "Deferido";
    }
}
