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
        DocumentacaoComprobatoria doc = new DocumentacaoComprobatoria("Certificado");
        HorasPorAtividade horas = new HorasPorAtividade("Conforme documento");

        map.put(1, new AtividadeComplementar("Monitoria", doc, horas, 60, this));
        map.put(2, new AtividadeComplementar("Curso de Línguas", doc, horas, 40, this));
        return map;
    }
}
