package ifsc.jvgc.template;

import ifsc.jvgc.model.AtividadeRealizada;
import ifsc.jvgc.strategy.EstrategiaValidacaoHoras;

public abstract class ProcessoValidacaoAtividade {
    public final void validar(AtividadeRealizada atividade, EstrategiaValidacaoHoras estrategia) {
        verificarDocumento(atividade);
        int horasValidadas = estrategia.calcularHorasValidas(atividade);
        registrarValidacao(atividade, horasValidadas);
        emitirParecer(atividade, horasValidadas);
    }

    protected abstract void verificarDocumento(AtividadeRealizada atividade);

    protected void registrarValidacao(AtividadeRealizada atividade, int horasValidadas) {
        System.out.println("Horas validadas: " + horasValidadas);
    }

    protected abstract void emitirParecer(AtividadeRealizada atividade, int horasValidadas);
}
