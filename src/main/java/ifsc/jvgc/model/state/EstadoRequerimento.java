package ifsc.jvgc.model.state;

import ifsc.jvgc.model.entities.Requerimento;

public interface EstadoRequerimento {
    void avaliar(Requerimento requerimento, boolean deferido);
    String nome();
}
