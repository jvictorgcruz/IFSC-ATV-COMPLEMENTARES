package ifsc.jvgc.model;

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

    public void definirHorasValidadas(int horasValidas) {
        this.horasValidadas = horasValidas;
    }

    public int horasValidadas() {
        return horasValidadas;
    }

    public int horasApresentadasAtividade(){
        return atividadeRealizada.horasApresentadas();
    }

    public int horasRestantesAtividade(){
        return atividadeRealizada.horasRestantesAtividade();
    }

    public int horasRestantesModalidade(){
        return atividadeRealizada.horasRestantesModalidade();
    }

    public String descricaoAtividade(){
        return this.atividadeRealizada.descricaoAtividade();
    }

    public String observacaoAtividade(){
        return this.atividadeRealizada.observacao();
    }

    public String descricaoHorasPorAtividade() {
        return this.atividadeRealizada.descricaoHorasPorAtividade();
    }

    public void definirObservacaoAtividade(String observacao) {
        this.atividadeRealizada.definirObservacao(observacao);
    }
}
