package ifsc.jvgc.model.entities.modalidades;

import ifsc.jvgc.model.entities.AtividadeComplementar;
import ifsc.jvgc.model.entities.modalidades.factory.AtividadesPesquisaInovacaoFactory;

import java.util.Map;

public class PesquisaInovacao extends Modalidade implements AtividadesModalidade {
    public PesquisaInovacao() {
        super("Pesquisa");
    }

    @Override
    public Map<Integer, AtividadeComplementar> atividades() {
        return new AtividadesPesquisaInovacaoFactory().criar(this);
    }
}
