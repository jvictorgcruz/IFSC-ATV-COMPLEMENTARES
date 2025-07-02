package ifsc.jvgc.model;

public class ProcessoValidacaoAtividade {
    public final ValidacaoAtividade validar(AtividadeRealizada realizada) {
        verificarDocumento(realizada);
        int horasValidas = realizada.calcularHorasValidas();
        ValidacaoAtividade validacao = new ValidacaoAtividade(realizada);
        registrarValidacao(validacao, horasValidas);
        return validacao;
    }

    protected void verificarDocumento(AtividadeRealizada atividade){
        System.out.println("Verificando documento: " + atividade.documento());
    };

    protected void registrarValidacao(ValidacaoAtividade validacao, int horasValidas) {
        validacao.definirHorasValidadas(horasValidas);
        String observacao = gerarObservacao(validacao);
        validacao.definirObservacaoAtividade(observacao);
    }

    protected String gerarObservacao(ValidacaoAtividade validacao) {
        int horasApresentadas = validacao.horasApresentadasAtividade();
        int horasValidadas = validacao.horasValidadas();
        if (horasValidadas < horasApresentadas){
            return String.format("Horas declaradas (%dh) excedem o limite (%dh); ajustadas para %dh.",
                    horasApresentadas, horasValidadas, horasValidadas);
        }
        return "";
    }

}
