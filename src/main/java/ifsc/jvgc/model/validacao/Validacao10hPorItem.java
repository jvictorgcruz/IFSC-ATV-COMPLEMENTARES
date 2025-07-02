package ifsc.jvgc.model.validacao;

import ifsc.jvgc.model.AtividadeRealizada;

public class Validacao10hPorItem implements EstrategiaValidacao {
    @Override
    public int calcularHorasValidas(AtividadeRealizada atividade) {
        int horasMaximas = new ValidacaoComLimiteMaximo().calcularHorasValidas(atividade);
        return Math.min(horasMaximas, 10);
    }
}

