package ifsc.jvgc.model.strategy;

import ifsc.jvgc.model.entities.AtividadeRealizada;

public class ValidacaoPorDocumento implements EstrategiaValidacaoHoras  {
    public int calcularHorasValidas(AtividadeRealizada atividade) {
        return atividade.horasApresentadas();
    }
}
