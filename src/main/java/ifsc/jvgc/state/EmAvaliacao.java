package ifsc.jvgc.state;

import ifsc.jvgc.model.Requerimento;

public class EmAvaliacao implements EstadoRequerimento {
    public void avaliar(Requerimento requerimento) {
        System.out.println("Requerimento em avaliação...");
        requerimento.setEstado(new Deferido());  // Exemplo de transição
    }
}
