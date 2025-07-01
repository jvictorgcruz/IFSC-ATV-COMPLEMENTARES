package ifsc.jvgc.model.state;

import ifsc.jvgc.model.entities.Requerimento;

public class EmAberto implements EstadoRequerimento{
    public void avaliar(Requerimento requerimento, boolean deferido) {
        System.out.println("Requerimento em avaliação...");
        requerimento.setEstado(new EmAvaliacao());
    }

    @Override
    public String nome() {
        return "Em aberto";
    }
}
