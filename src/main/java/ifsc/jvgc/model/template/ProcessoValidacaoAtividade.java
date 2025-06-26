package ifsc.jvgc.model.template;

import ifsc.jvgc.model.entities.AtividadeRealizada;
import ifsc.jvgc.model.entities.ValidacaoAtividade;
import ifsc.jvgc.model.strategy.EstrategiaValidacaoHoras;

public abstract class ProcessoValidacaoAtividade {
    public final ValidacaoAtividade validar(AtividadeRealizada atividade, EstrategiaValidacaoHoras estrategia) {
        verificarDocumento(atividade);
        int horasValidadas = estrategia.calcularHorasValidas(atividade);
        registrarValidacao(atividade, horasValidadas);
        return new ValidacaoAtividade(atividade, horasValidadas);
    }

    protected abstract void verificarDocumento(AtividadeRealizada atividade);

    protected void registrarValidacao(AtividadeRealizada atividade, int horasValidadas) {
        atividade.definirHorasValidadas(horasValidadas);
        atividade.definirObservacao(gerarObservacao(atividade));
    }

    protected String gerarObservacao(AtividadeRealizada atividade){
        int horasApresentadas = atividade.horasApresentadas();
        int horasValidadas = atividade.horasValidadas();
        if (horasValidadas < horasApresentadas){
            return String.format("Horas declaradas (%dh) excedem o limite (%dh); ajustadas para %dh.",
                    horasApresentadas, horasValidadas, horasValidadas);
        }
        return "";
    }

}
