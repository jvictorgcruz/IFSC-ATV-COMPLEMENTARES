package ifsc.jvgc.model.strategy;

import ifsc.jvgc.model.entities.AtividadeRealizada;

public interface EstrategiaValidacaoHoras {
    int calcularHorasValidas(AtividadeRealizada atividade);
}
