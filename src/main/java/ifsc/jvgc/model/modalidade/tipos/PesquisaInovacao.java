package ifsc.jvgc.model.modalidade.tipos;

import ifsc.jvgc.model.AtividadeComplementar;
import ifsc.jvgc.model.modalidade.atividades.AtividadesPesquisaInovacaoFactory;

import java.util.Map;

public class PesquisaInovacao extends Modalidade implements AtividadesModalidade {
    public PesquisaInovacao() {
        super("Pesquisa");
    }

    @Override
    public Map<Integer, AtividadeComplementar> atividades() {
        return new AtividadesPesquisaInovacaoFactory().criar(this);
    }

    @Override
    public double proporcaoPermitida() {
        return 0.4;
    }
}
