package ifsc.jvgc.model.entities.modalidades;

import ifsc.jvgc.model.entities.AtividadeComplementar;
import ifsc.jvgc.model.entities.modalidades.factory.AtividadesComplementacaoFactory;

import java.util.Map;

public class Complementacao extends Modalidade {
    public Complementacao() {
        super("Complementacao");
    }

    @Override
    public Map<Integer, AtividadeComplementar> atividades() {
        return new AtividadesComplementacaoFactory().criar(this);
    }
}
