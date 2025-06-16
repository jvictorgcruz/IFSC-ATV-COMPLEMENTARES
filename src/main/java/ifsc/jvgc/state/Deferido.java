package ifsc.jvgc.state;

import ifsc.jvgc.model.Requerimento;

public class Deferido implements EstadoRequerimento {
    public void avaliar(Requerimento requerimento) {
        System.out.println("Requerimento já deferido. Nenhuma ação.");
    }

    @Override
    public String nome() {
        return "Deferido";
    }
}
