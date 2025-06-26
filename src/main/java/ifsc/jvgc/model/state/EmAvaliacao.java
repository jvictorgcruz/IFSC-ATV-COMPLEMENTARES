package ifsc.jvgc.model.state;

import ifsc.jvgc.model.entities.Requerimento;

public class EmAvaliacao implements EstadoRequerimento {
    public void avaliar(Requerimento requerimento) {
        System.out.println("Requerimento em avaliação...");
        requerimento.setEstado(new Deferido());  // Exemplo de transição
    }

    @Override
    public String nome() {
        return "Em avaliação";
    }
}
