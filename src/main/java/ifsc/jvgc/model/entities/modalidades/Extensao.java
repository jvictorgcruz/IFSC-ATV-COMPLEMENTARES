package ifsc.jvgc.model.entities.modalidades;

import ifsc.jvgc.model.entities.AtividadeComplementar;
import ifsc.jvgc.model.entities.DocumentacaoComprobatoria;
import ifsc.jvgc.model.entities.HorasPorAtividade;

import java.util.LinkedHashMap;
import java.util.Map;

public class Extensao extends Modalidade {
    public Extensao() {
        super("Extensão");
    }

    @Override
    public Map<Integer, AtividadeComplementar> atividades() {
        Map<Integer, AtividadeComplementar> map = new LinkedHashMap<>();
        map.put(1, new AtividadeComplementar("Participação em projeto de extensão",
                new DocumentacaoComprobatoria("Declaração de participação"),
                new HorasPorAtividade("Conforme documento comprobatório"), 60, this));
        map.put(2, new AtividadeComplementar("Estágio não obrigatório",
                new DocumentacaoComprobatoria("Declaração do empregador"),
                new HorasPorAtividade("25 horas por mes"), 100, this));
        return map;
    }
}
