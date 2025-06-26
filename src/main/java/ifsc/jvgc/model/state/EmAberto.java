package ifsc.jvgc.model.state;

import ifsc.jvgc.model.entities.Requerimento;

public class EmAberto implements EstadoRequerimento{
    public void avaliar(Requerimento requerimento) {
        System.out.println("Requerimento criado");
        requerimento.setEstado(new EmAvaliacao());  // Exemplo de transição
    }

    @Override
    public String nome() {
        return "Em aberto";
    }
}
