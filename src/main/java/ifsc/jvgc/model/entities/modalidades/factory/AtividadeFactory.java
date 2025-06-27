package ifsc.jvgc.model.entities.modalidades.factory;

import ifsc.jvgc.model.entities.AtividadeComplementar;
import ifsc.jvgc.model.entities.modalidades.Modalidade;

import java.util.Map;

public interface AtividadeFactory {
    Map<Integer, AtividadeComplementar> criar(Modalidade modalidade);
}
