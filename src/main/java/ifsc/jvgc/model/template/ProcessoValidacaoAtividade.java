package ifsc.jvgc.model.template;

import ifsc.jvgc.model.entities.AtividadeRealizada;
import ifsc.jvgc.model.entities.ValidacaoAtividade;

public abstract class ProcessoValidacaoAtividade {
    public final ValidacaoAtividade validar(AtividadeRealizada realizada) {
        verificarDocumento(realizada);
        int horasValidas = realizada.atividade().estrategia().calcularHorasValidas(realizada);
        registrarValidacao(realizada, horasValidas);
        return new ValidacaoAtividade(realizada, horasValidas);
    }

    protected abstract void verificarDocumento(AtividadeRealizada atividade);

    protected void registrarValidacao(AtividadeRealizada atividade, int horasValidas) {
        atividade.definirHorasValidadas(horasValidas);
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
