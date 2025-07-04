package ifsc.jvgc.model.modalidade.atividades;

import ifsc.jvgc.model.AtividadeComplementar;
import ifsc.jvgc.model.DocumentacaoComprobatoria;
import ifsc.jvgc.model.HorasPorAtividade;
import ifsc.jvgc.model.modalidade.tipos.Modalidade;
import ifsc.jvgc.model.validacao.Validacao4hPorItem;
import ifsc.jvgc.model.validacao.ValidacaoPorDocumento;

import java.util.LinkedHashMap;
import java.util.Map;

public class AtividadesComplementacaoFactory implements AtividadeFactory {
    public Map<Integer, AtividadeComplementar> criar(Modalidade modalidade) {
        Map<Integer, AtividadeComplementar> map = new LinkedHashMap<>();

        map.put(1, new AtividadeComplementar("Palestra técnica",
                new DocumentacaoComprobatoria("Declaração de participação"),
                new HorasPorAtividade("4 horas por atividade"), 20, modalidade,
                new Validacao4hPorItem()));

        map.put(2, new AtividadeComplementar("Curso de lingua estrangeira",
                new DocumentacaoComprobatoria("Certificado de participação"),
                new HorasPorAtividade("Conforme documento comprobatório"), 80, modalidade,
                new ValidacaoPorDocumento()));

        return map;
    }
}
