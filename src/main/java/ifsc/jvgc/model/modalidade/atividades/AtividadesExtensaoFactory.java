package ifsc.jvgc.model.modalidade.atividades;

import ifsc.jvgc.model.AtividadeComplementar;
import ifsc.jvgc.model.DocumentacaoComprobatoria;
import ifsc.jvgc.model.HorasPorAtividade;
import ifsc.jvgc.model.modalidade.tipos.Modalidade;
import ifsc.jvgc.model.validacao.Validacao25hPorMes;
import ifsc.jvgc.model.validacao.ValidacaoPorDocumento;

import java.util.LinkedHashMap;
import java.util.Map;

public class AtividadesExtensaoFactory implements AtividadeFactory {
    public Map<Integer, AtividadeComplementar> criar(Modalidade modalidade) {
        Map<Integer, AtividadeComplementar> map = new LinkedHashMap<>();

        map.put(1, new AtividadeComplementar("Participação em projeto de extensão",
                new DocumentacaoComprobatoria("Declaração de participação"),
                new HorasPorAtividade("Conforme documento comprobatório"), 60, modalidade,
                new ValidacaoPorDocumento()));

        map.put(2, new AtividadeComplementar("Estágio não obrigatório",
                new DocumentacaoComprobatoria("Declaração do empregador"),
                new HorasPorAtividade("25 horas por mes"), 100, modalidade,
                new Validacao25hPorMes()));

        return map;
    }
}
