package ifsc.jvgc.model.strategy;

import ifsc.jvgc.model.entities.AtividadeRealizada;

public interface EstrategiaValidacao {
    int calcularHorasValidas(AtividadeRealizada atividade);
}
