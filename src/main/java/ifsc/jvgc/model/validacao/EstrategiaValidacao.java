package ifsc.jvgc.model.validacao;

import ifsc.jvgc.model.AtividadeRealizada;

public interface EstrategiaValidacao {
    int calcularHorasValidas(AtividadeRealizada atividade);
}
