package ifsc.jvgc.model.template;

import ifsc.jvgc.model.entities.AtividadeRealizada;
import ifsc.jvgc.model.entities.ValidacaoAtividade;

public abstract class ProcessoValidacaoAtividade {
    public final ValidacaoAtividade validar(AtividadeRealizada realizada) {
        verificarDocumento(realizada);
        int horasValidas = realizada.atividade().estrategia().calcularHorasValidas(realizada);
        ValidacaoAtividade validacao = new ValidacaoAtividade(realizada);
        registrarValidacao(validacao, horasValidas);
        return validacao;
    }

    protected abstract void verificarDocumento(AtividadeRealizada atividade);

    protected void registrarValidacao(ValidacaoAtividade validacao, int horasValidas) {
        validacao.definirHorasValidadas(horasValidas);
        validacao.atividadeRealizada().definirObservacao(gerarObservacao(validacao));
    }

    protected String gerarObservacao(ValidacaoAtividade validacao) {
        int horasApresentadas = validacao.atividadeRealizada().horasApresentadas();
        int horasValidadas = validacao.horasValidadas();
        if (horasValidadas < horasApresentadas){
            return String.format("Horas declaradas (%dh) excedem o limite (%dh); ajustadas para %dh.",
                    horasApresentadas, horasValidadas, horasValidadas);
        }
        return "";
    }

}
