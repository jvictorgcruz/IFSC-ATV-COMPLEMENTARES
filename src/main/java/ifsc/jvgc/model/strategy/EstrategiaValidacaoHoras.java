package ifsc.jvgc.strategy;

import ifsc.jvgc.model.AtividadeRealizada;

public interface EstrategiaValidacaoHoras {
    int calcularHorasValidas(AtividadeRealizada atividade);
}
