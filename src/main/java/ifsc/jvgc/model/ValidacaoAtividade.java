package ifsc.jvgc.model;

public class ValidacaoAtividade {
    private final int id;
    private final AtividadeRealizada atividadeRealizada;
    private final int horasValidadas;
    private final Parecer parecer;

    public ValidacaoAtividade(int id, AtividadeRealizada atividadeRealizada, int horasValidadas, Parecer parecer) {
        this.id = id;
        this.atividadeRealizada = atividadeRealizada;
        this.horasValidadas = horasValidadas;
        this.parecer = parecer;
    }

    @Override
    public String toString() {
        return "ValidacaoAtividade{id=" + id + ", horasValidadas=" + horasValidadas + "}";
    }
}
