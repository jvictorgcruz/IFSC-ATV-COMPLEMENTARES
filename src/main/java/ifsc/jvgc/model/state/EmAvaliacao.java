package ifsc.jvgc.model.state;

import ifsc.jvgc.model.entities.Requerimento;

public class EmAvaliacao implements EstadoRequerimento {
    public void avaliar(Requerimento requerimento) {
        System.out.println("Requerimento deferido");
        requerimento.setEstado(new Deferido());
        requerimento.validar();
    }

    @Override
    public String nome() {
        return "Em avaliação";
    }
}
