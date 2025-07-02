package ifsc.jvgc.model.modalidade.tipos;

import ifsc.jvgc.model.AtividadeComplementar;
import ifsc.jvgc.model.modalidade.atividades.AtividadesEnsinoFactory;

import java.util.Map;

public class Ensino extends Modalidade implements AtividadesModalidade {
    public Ensino() {super("Ensino");}

    @Override
    public Map<Integer, AtividadeComplementar> atividades() {
        return new AtividadesEnsinoFactory().criar(this);
    }

    @Override
    public double proporcaoPermitida() {
        return 0.4;
    }
}
