package ifsc.jvgc.model.entities.modalidades;

import ifsc.jvgc.model.entities.AtividadeComplementar;
import ifsc.jvgc.model.entities.modalidades.factory.AtividadesEnsinoFactory;

import java.util.Map;

public class Ensino extends Modalidade {
    public Ensino() {super("Ensino");}

    @Override
    public Map<Integer, AtividadeComplementar> atividades() {
        return new AtividadesEnsinoFactory().criar(this);
    }
}
