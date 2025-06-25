package ifsc.jvgc.model.modalidades;

import ifsc.jvgc.model.AtividadeComplementar;
import ifsc.jvgc.model.DocumentacaoComprobatoria;
import ifsc.jvgc.model.HorasPorAtividade;

import java.util.LinkedHashMap;
import java.util.Map;

public class RepresentacaoDiscente extends Modalidade {
    public RepresentacaoDiscente(int id) {
        super(id, "Representação Discente");
    }
    @Override
    public Map<Integer, AtividadeComplementar> atividades() {
        Map<Integer, AtividadeComplementar> map = new LinkedHashMap<>();
        DocumentacaoComprobatoria doc = new DocumentacaoComprobatoria(1, "Certificado");
        HorasPorAtividade horas = new HorasPorAtividade(1, "Conforme documento");

        map.put(1, new AtividadeComplementar(6, "Representante de Turma", doc, horas, 30, this));
        return map;
    }
}
