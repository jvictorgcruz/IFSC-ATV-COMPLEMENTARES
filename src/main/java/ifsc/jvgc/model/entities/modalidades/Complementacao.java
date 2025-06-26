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
        DocumentacaoComprobatoria doc = new DocumentacaoComprobatoria("Certificado");
        HorasPorAtividade horas = new HorasPorAtividade("Conforme documento");

        map.put(1, new AtividadeComplementar("Representante de Turma", doc, horas, 30, this));
        return map;
    }
}
