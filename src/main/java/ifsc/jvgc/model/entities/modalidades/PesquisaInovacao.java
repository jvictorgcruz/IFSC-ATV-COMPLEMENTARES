package ifsc.jvgc.model.entities.modalidades;

import ifsc.jvgc.model.entities.AtividadeComplementar;
import ifsc.jvgc.model.entities.DocumentacaoComprobatoria;
import ifsc.jvgc.model.entities.HorasPorAtividade;

import java.util.LinkedHashMap;
import java.util.Map;

public class PesquisaInovacao extends Modalidade {
    public PesquisaInovacao() {
        super("Pesquisa");
    }
    @Override
    public Map<Integer, AtividadeComplementar> atividades() {
        Map<Integer, AtividadeComplementar> map = new LinkedHashMap<>();
        map.put(1, new AtividadeComplementar("Participação em programa de iniciação cientifica",
                new DocumentacaoComprobatoria("Declaração de participação"),
                new HorasPorAtividade("Conforme documento comprobatório"), 60, this));
        map.put(2, new AtividadeComplementar("Autoria de artigo publicado",
                new DocumentacaoComprobatoria("Capa do artigo"),
                new HorasPorAtividade("10 horas por item"), 30, this));
        return map;
    }
}
