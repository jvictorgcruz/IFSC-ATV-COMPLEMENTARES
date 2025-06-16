package ifsc.jvgc.strategy;

import ifsc.jvgc.model.AtividadeRealizada;

public class ValidacaoPorDocumento {
    public int calcularHorasValidas(AtividadeRealizada atividade) {
        return atividade.horasApresentadas();
    }
}
