package ifsc.jvgc.model.strategy;

import ifsc.jvgc.model.entities.AtividadeRealizada;

public class Validacao25hPorMes implements EstrategiaValidacao {
    @Override
    public int calcularHorasValidas(AtividadeRealizada atividade) {
        return new ValidacaoComLimiteMaximo().calcularHorasValidas(atividade);
    }
}

