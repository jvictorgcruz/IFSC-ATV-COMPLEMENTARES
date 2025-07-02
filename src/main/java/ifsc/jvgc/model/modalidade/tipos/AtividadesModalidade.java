package ifsc.jvgc.model.modalidade.tipos;

import ifsc.jvgc.model.AtividadeComplementar;

import java.util.Map;

public interface AtividadesModalidade {
    Map<Integer, AtividadeComplementar> atividades();
    double proporcaoPermitida();;
}
