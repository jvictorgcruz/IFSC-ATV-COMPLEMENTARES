package ifsc.jvgc.model.modalidades;

import ifsc.jvgc.model.AtividadeComplementar;
import ifsc.jvgc.model.DocumentacaoComprobatoria;
import ifsc.jvgc.model.HorasPorAtividade;

import java.util.LinkedHashMap;
import java.util.Map;

public class Pesquisa extends Modalidade {
    public Pesquisa() {
        super("Pesquisa");
    }
    @Override
    public Map<Integer, AtividadeComplementar> atividades() {
        Map<Integer, AtividadeComplementar> map = new LinkedHashMap<>();
        DocumentacaoComprobatoria doc = new DocumentacaoComprobatoria("Certificado");
        HorasPorAtividade horas = new HorasPorAtividade("Conforme documento");

        map.put(1, new AtividadeComplementar("Iniciação Científica", doc, horas, 100, this));
        map.put(2, new AtividadeComplementar("Publicação de Artigo", doc, horas, 80, this));
        return map;
    }
}
