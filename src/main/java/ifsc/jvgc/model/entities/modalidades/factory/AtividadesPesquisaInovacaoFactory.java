package ifsc.jvgc.model.entities.modalidades.factory;

import ifsc.jvgc.model.entities.AtividadeComplementar;
import ifsc.jvgc.model.entities.DocumentacaoComprobatoria;
import ifsc.jvgc.model.entities.HorasPorAtividade;
import ifsc.jvgc.model.entities.modalidades.Modalidade;
import ifsc.jvgc.model.strategy.Validacao10hPorItem;
import ifsc.jvgc.model.strategy.ValidacaoPorDocumento;

import java.util.LinkedHashMap;
import java.util.Map;

public class AtividadesPesquisaInovacaoFactory implements AtividadeFactory {
    public Map<Integer, AtividadeComplementar> criar(Modalidade modalidade) {
        Map<Integer, AtividadeComplementar> map = new LinkedHashMap<>();

        map.put(1, new AtividadeComplementar("Participação em programa de iniciação cientifica",
                new DocumentacaoComprobatoria("Declaração de participação"),
                new HorasPorAtividade("Conforme documento comprobatório"), 60, modalidade,
                new ValidacaoPorDocumento()));

        map.put(2, new AtividadeComplementar("Autoria de artigo publicado",
                new DocumentacaoComprobatoria("Capa do artigo"),
                new HorasPorAtividade("10 horas por item"), 30, modalidade,
                new Validacao10hPorItem()));

        return map;
    }
}
