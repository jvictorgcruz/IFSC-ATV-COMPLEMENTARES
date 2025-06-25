package ifsc.jvgc.model;

public class ValidacaoAtividade {
    private int id;
    private final AtividadeRealizada atividadeRealizada;
    private final int horasValidadas;
    private final Parecer parecer;

    public ValidacaoAtividade(AtividadeRealizada atividadeRealizada, int horasValidadas, Parecer parecer) {
        this.atividadeRealizada = atividadeRealizada;
        this.horasValidadas = horasValidadas;
        this.parecer = parecer;
    }

}
