package ifsc.jvgc.model.entities;

public class ValidacaoAtividade {
    private int id;
    private final AtividadeRealizada atividadeRealizada;
    private int horasValidadas;
    private Parecer parecer;

    public ValidacaoAtividade(AtividadeRealizada atividadeRealizada) {
        this.atividadeRealizada = atividadeRealizada;
    }

    public void definirParecer(Parecer parecer) {
        this.parecer = parecer;
    }

    public AtividadeRealizada atividadeRealizada() {
        return atividadeRealizada;
    }

    public void definirHorasValidadas(int horasValidas) {
        this.horasValidadas = horasValidas;
    }

    public int horasValidadas() {
        return horasValidadas;
    }

}
