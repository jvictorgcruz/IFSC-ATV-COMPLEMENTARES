package ifsc.jvgc.model.modalidade.tipos;

import ifsc.jvgc.model.AtividadeComplementar;
import ifsc.jvgc.model.modalidade.atividades.AtividadesExtensaoFactory;

import java.util.Map;

public class Extensao extends Modalidade implements AtividadesModalidade {
    public Extensao() {
        super("Extensão");
    }

    @Override
    public Map<Integer, AtividadeComplementar> atividades() {
        return new AtividadesExtensaoFactory().criar(this);
    }

    @Override
    public double proporcaoPermitida() {
        return 0.4;
    }
}
