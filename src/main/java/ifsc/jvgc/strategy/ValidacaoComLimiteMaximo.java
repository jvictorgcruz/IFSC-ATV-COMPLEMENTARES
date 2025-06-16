package ifsc.jvgc.strategy;

import ifsc.jvgc.model.AtividadeRealizada;

public class ValidacaoComLimiteMaximo {
    public int calcularHorasValidas(AtividadeRealizada atividade) {
        return Math.min(atividade.getHorasApresentadas(), atividade.getAtividade().getLimiteMaximo());
    }
}
