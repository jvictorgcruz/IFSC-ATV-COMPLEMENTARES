package ifsc.jvgc.model.modalidades;

import ifsc.jvgc.model.AtividadeComplementar;
import ifsc.jvgc.model.DocumentacaoComprobatoria;
import ifsc.jvgc.model.HorasPorAtividade;

import java.util.LinkedHashMap;
import java.util.Map;

public class Pesquisa extends Modalidade {
    public Pesquisa(int id) {
        super(id, "Pesquisa");
    }
    @Override
    public Map<Integer, AtividadeComplementar> atividades() {
        Map<Integer, AtividadeComplementar> map = new LinkedHashMap<>();
        DocumentacaoComprobatoria doc = new DocumentacaoComprobatoria(1, "Certificado");
        HorasPorAtividade horas = new HorasPorAtividade(1, "Conforme documento");

        map.put(1, new AtividadeComplementar(3, "Iniciação Científica", doc, horas, 100, this));
        map.put(2, new AtividadeComplementar(4, "Publicação de Artigo", doc, horas, 80, this));
        return map;
    }
}
