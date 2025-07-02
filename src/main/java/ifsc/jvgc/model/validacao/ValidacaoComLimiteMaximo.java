package ifsc.jvgc.model.validacao;

import ifsc.jvgc.model.AtividadeRealizada;

public class ValidacaoComLimiteMaximo implements EstrategiaValidacao {
    @Override
    public int calcularHorasValidas(AtividadeRealizada atividade) {
        return Math.min(atividade.horasApresentadas(),
                Math.min(atividade.horasRestantesModalidade(), atividade.horasRestantesAtividade())
            );
    }
}
