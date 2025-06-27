package ifsc.jvgc.model.entities.modalidades.factory;

import ifsc.jvgc.model.entities.AtividadeComplementar;
import ifsc.jvgc.model.entities.DocumentacaoComprobatoria;
import ifsc.jvgc.model.entities.HorasPorAtividade;
import ifsc.jvgc.model.entities.modalidades.Modalidade;
import ifsc.jvgc.model.strategy.ValidacaoPorDocumento;

import java.util.LinkedHashMap;
import java.util.Map;

public class AtividadesEnsinoFactory implements AtividadeFactory {
    public Map<Integer, AtividadeComplementar> criar(Modalidade modalidade) {
        Map<Integer, AtividadeComplementar> map = new LinkedHashMap<>();

        map.put(1, new AtividadeComplementar("Ministrar aula de reforço",
                new DocumentacaoComprobatoria("Declaração de instituição promotora"),
                new HorasPorAtividade("Conforme documento comprobatório"), 70, modalidade,
                new ValidacaoPorDocumento()));

        map.put(2, new AtividadeComplementar("Monitoria de laboratório",
                new DocumentacaoComprobatoria("Declaração de participação"),
                new HorasPorAtividade("Conforme documento comprobatório"), 70, modalidade,
                new ValidacaoPorDocumento()));

        return map;
    }
}
