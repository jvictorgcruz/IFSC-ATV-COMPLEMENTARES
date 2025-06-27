package ifsc.jvgc.model.entities.modalidades;

import ifsc.jvgc.model.entities.AtividadeComplementar;
import ifsc.jvgc.model.entities.DocumentacaoComprobatoria;
import ifsc.jvgc.model.entities.HorasPorAtividade;

import java.util.LinkedHashMap;
import java.util.Map;

public class Complementacao extends Modalidade {
    public Complementacao() {
        super("Representação Discente");
    }
    @Override
    public Map<Integer, AtividadeComplementar> atividades() {
        Map<Integer, AtividadeComplementar> map = new LinkedHashMap<>();

        map.put(1, new AtividadeComplementar("Palestra técnica",
                new DocumentacaoComprobatoria("Declaração de participação"),
                new HorasPorAtividade("4 horas por atividade"), 20, this));
        map.put(2, new AtividadeComplementar("Curso de lingua estrangeira",
                new DocumentacaoComprobatoria("Certificado de participação"),
                new HorasPorAtividade("Conforme documento comprobatório"), 80, this));
        return map;
    }
}
