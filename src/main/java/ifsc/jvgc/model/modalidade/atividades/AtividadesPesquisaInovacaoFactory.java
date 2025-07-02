package ifsc.jvgc.model.modalidade.atividades;

import ifsc.jvgc.model.AtividadeComplementar;
import ifsc.jvgc.model.DocumentacaoComprobatoria;
import ifsc.jvgc.model.HorasPorAtividade;
import ifsc.jvgc.model.modalidade.tipos.Modalidade;
import ifsc.jvgc.model.validacao.Validacao10hPorItem;
import ifsc.jvgc.model.validacao.ValidacaoPorDocumento;

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
