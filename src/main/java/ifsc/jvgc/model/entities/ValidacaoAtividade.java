package ifsc.jvgc.model.entities;

public class ValidacaoAtividade {
    private int id;
    private final AtividadeRealizada atividadeRealizada;
    private final int horasValidadas;
    private Parecer parecer;

    public ValidacaoAtividade(AtividadeRealizada atividadeRealizada, int horasValidadas) {
        this.atividadeRealizada = atividadeRealizada;
        this.horasValidadas = horasValidadas;
    }

    public ValidacaoAtividade(AtividadeRealizada atividadeRealizada, int horasValidadas, Parecer parecer) {
        this.atividadeRealizada = atividadeRealizada;
        this.horasValidadas = horasValidadas;
        this.parecer = parecer;
    }

    public void definirParecer(Parecer parecer) {
        this.parecer = parecer;
    }

    public AtividadeRealizada atividadeRealizada() {
        return atividadeRealizada;
    }

}
