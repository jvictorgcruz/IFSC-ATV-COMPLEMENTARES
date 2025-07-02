package ifsc.jvgc.model.validacao;

import ifsc.jvgc.model.AtividadeRealizada;

public class ValidacaoPorDocumento implements EstrategiaValidacao {
    @Override
    public int calcularHorasValidas(AtividadeRealizada atividade) {
        return new ValidacaoComLimiteMaximo().calcularHorasValidas(atividade);
    }

}
