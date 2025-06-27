package ifsc.jvgc.model.strategy;

import ifsc.jvgc.model.entities.AtividadeRealizada;

public class Validacao4hPorItem implements EstrategiaValidacao {
    @Override
    public int calcularHorasValidas(AtividadeRealizada atividade) {
        int horasMaximas = new ValidacaoComLimiteMaximo().calcularHorasValidas(atividade);
        return Math.min(horasMaximas, 4);
    }
}

