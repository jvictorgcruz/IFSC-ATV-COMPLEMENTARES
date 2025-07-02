package ifsc.jvgc.model.validacao;

import ifsc.jvgc.model.AtividadeRealizada;

public class Validacao25hPorMes implements EstrategiaValidacao {
    @Override
    public int calcularHorasValidas(AtividadeRealizada atividade) {
        return new ValidacaoComLimiteMaximo().calcularHorasValidas(atividade);
    }
}

