package ifsc.jvgc.strategy;

import ifsc.jvgc.model.AtividadeRealizada;

public class ValidacaoFixaPorTipo implements EstrategiaValidacaoHoras  {
    public int calcularHorasValidas(AtividadeRealizada atividade) {
        return 10;
    }
}
