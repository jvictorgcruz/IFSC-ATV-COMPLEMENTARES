package ifsc.jvgc.model.entities.modalidades;

import ifsc.jvgc.model.entities.AtividadeComplementar;
import ifsc.jvgc.model.entities.modalidades.factory.AtividadesExtensaoFactory;

import java.util.Map;

public class Extensao extends Modalidade {
    public Extensao() {
        super("Extensão");
    }

    @Override
    public Map<Integer, AtividadeComplementar> atividades() {
        return new AtividadesExtensaoFactory().criar(this);
    }
}
