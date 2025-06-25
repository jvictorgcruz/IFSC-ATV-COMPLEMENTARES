package ifsc.jvgc.model.modalidades;

import ifsc.jvgc.model.AtividadeComplementar;
import ifsc.jvgc.model.DocumentacaoComprobatoria;
import ifsc.jvgc.model.HorasPorAtividade;

import java.util.LinkedHashMap;
import java.util.Map;

public class Extensao extends Modalidade {
    public Extensao(int id) {
        super(id, "Extensão");
    }

    @Override
    public Map<Integer, AtividadeComplementar> atividades() {
        Map<Integer, AtividadeComplementar> map = new LinkedHashMap<>();
        DocumentacaoComprobatoria doc = new DocumentacaoComprobatoria(1, "Certificado");
        HorasPorAtividade horas = new HorasPorAtividade(1, "Conforme documento");

        map.put(1, new AtividadeComplementar(5, "Curso de Extensão", doc, horas, 40, this));
        return map;
    }
}
