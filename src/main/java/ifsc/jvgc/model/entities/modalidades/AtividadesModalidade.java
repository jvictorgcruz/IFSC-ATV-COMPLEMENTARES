package ifsc.jvgc.model.entities.modalidades;

import ifsc.jvgc.model.entities.AtividadeComplementar;

import java.util.Map;

public interface AtividadesModalidade {
    Map<Integer, AtividadeComplementar> atividades();
    double proporcaoPermitida();;
}
