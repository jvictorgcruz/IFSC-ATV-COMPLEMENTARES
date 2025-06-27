package ifsc.jvgc.model.entities.modalidades;

import ifsc.jvgc.model.entities.AtividadeComplementar;
import ifsc.jvgc.model.entities.DocumentacaoComprobatoria;
import ifsc.jvgc.model.entities.HorasPorAtividade;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ensino extends Modalidade {
    public Ensino() {
        super("Ensino");
    }

    @Override
    public Map<Integer, AtividadeComplementar> atividades() {
        Map<Integer, AtividadeComplementar> map = new LinkedHashMap<>();
        map.put(1, new AtividadeComplementar("Ministrar aula de reforço",
                new DocumentacaoComprobatoria("Declaração de instituição promotora"),
                new HorasPorAtividade("Conforme documento comprobatório"), 70, this));
        map.put(2, new AtividadeComplementar("Monitoria de laboratório",
                new DocumentacaoComprobatoria("Declaração de participação"),
                new HorasPorAtividade("Conforme documento comprobatório"), 70, this));
        return map;
    }
}
