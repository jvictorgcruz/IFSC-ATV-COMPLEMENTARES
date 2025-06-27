package ifsc.jvgc.model.strategy;

import ifsc.jvgc.model.entities.AtividadeRealizada;

public class ValidacaoComLimiteMaximo implements EstrategiaValidacao {
    @Override
    public int calcularHorasValidas(AtividadeRealizada atividade) {
        return Math.min(atividade.horasApresentadas(), atividade.atividade().limiteMaximo());
    }
}
