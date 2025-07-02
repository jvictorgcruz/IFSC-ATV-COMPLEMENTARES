package ifsc.jvgc.model.modalidade.atividades;

import ifsc.jvgc.model.AtividadeComplementar;
import ifsc.jvgc.model.DocumentacaoComprobatoria;
import ifsc.jvgc.model.HorasPorAtividade;
import ifsc.jvgc.model.modalidade.tipos.Modalidade;
import ifsc.jvgc.model.validacao.ValidacaoPorDocumento;

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
