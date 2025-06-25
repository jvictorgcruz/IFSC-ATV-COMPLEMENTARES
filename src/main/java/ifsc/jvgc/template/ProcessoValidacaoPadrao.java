package ifsc.jvgc.template;

import ifsc.jvgc.model.AtividadeRealizada;

public class ProcessoValidacaoPadrao extends ProcessoValidacaoAtividade {
    protected void verificarDocumento(AtividadeRealizada atividade) {
        System.out.println("Verificando documento: " + atividade.documento());
    }

}
