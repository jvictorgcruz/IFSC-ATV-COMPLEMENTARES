package ifsc.jvgc.state;

import ifsc.jvgc.model.Requerimento;

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
