package ifsc.jvgc.model.modalidades;

import ifsc.jvgc.model.AtividadeComplementar;
import ifsc.jvgc.model.DocumentacaoComprobatoria;
import ifsc.jvgc.model.HorasPorAtividade;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ensino extends Modalidade {
    public Ensino(int id) {
        super(id, "Ensino");
    }

    @Override
    public Map<Integer, AtividadeComplementar> atividades() {
        Map<Integer, AtividadeComplementar> map = new LinkedHashMap<>();
        DocumentacaoComprobatoria doc = new DocumentacaoComprobatoria(1, "Certificado");
        HorasPorAtividade horas = new HorasPorAtividade(1, "Conforme documento");

        map.put(1, new AtividadeComplementar(1, "Monitoria", doc, horas, 60, this));
        map.put(2, new AtividadeComplementar(2, "Curso de Línguas", doc, horas, 40, this));
        return map;
    }
}
