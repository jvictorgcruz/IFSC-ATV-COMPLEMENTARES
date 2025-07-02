package ifsc.jvgc.model.modalidade.atividades;

import ifsc.jvgc.model.AtividadeComplementar;
import ifsc.jvgc.model.modalidade.tipos.Modalidade;

import java.util.Map;

public interface AtividadeFactory {
    Map<Integer, AtividadeComplementar> criar(Modalidade modalidade);
}
