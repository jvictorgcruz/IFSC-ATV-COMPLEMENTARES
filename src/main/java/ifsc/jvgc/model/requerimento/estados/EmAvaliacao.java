package ifsc.jvgc.model.requerimento.estados;

import ifsc.jvgc.model.requerimento.Requerimento;

public class EmAvaliacao implements EstadoRequerimento {
    public void avaliar(Requerimento requerimento, boolean deferido) {
        System.out.println("Requerimento deferido");
        if (deferido) {
            requerimento.setEstado(new Deferido());
            requerimento.validar();
            return;
        }
        requerimento.setEstado(new Indeferido());
    }

    @Override
    public String nome() {
        return "Em avaliação";
    }
}
