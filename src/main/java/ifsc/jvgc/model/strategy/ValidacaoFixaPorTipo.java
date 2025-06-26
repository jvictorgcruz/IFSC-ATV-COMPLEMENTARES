package ifsc.jvgc.model.strategy;

import ifsc.jvgc.model.entities.AtividadeRealizada;

public class ValidacaoFixaPorTipo implements EstrategiaValidacaoHoras  {
    public int calcularHorasValidas(AtividadeRealizada atividade) {
        return 10;
    }
}
