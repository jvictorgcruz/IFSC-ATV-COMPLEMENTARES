package ifsc.jvgc.model.requerimento.estados;

import ifsc.jvgc.model.requerimento.Requerimento;

public interface EstadoRequerimento {
    void avaliar(Requerimento requerimento, boolean deferido);
    String nome();
}
