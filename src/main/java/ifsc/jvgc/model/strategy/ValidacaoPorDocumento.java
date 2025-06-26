package ifsc.jvgc.strategy;

import ifsc.jvgc.model.AtividadeRealizada;

public class ValidacaoPorDocumento implements EstrategiaValidacaoHoras  {
    public int calcularHorasValidas(AtividadeRealizada atividade) {
        return atividade.horasApresentadas();
    }
}
