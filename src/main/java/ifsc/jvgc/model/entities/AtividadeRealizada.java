package ifsc.jvgc.model.entities;

public class AtividadeRealizada {
    private int id;
    private final Requerimento requerimento;
    private final AtividadeComplementar atividade;
    private final int horasApresentadas;
    private final int horasRestantesModalidade;
    private final String documento;
    private String observacao = "";

    public AtividadeRealizada(Requerimento requerimento, AtividadeComplementar atividade,
                              int horasApresentadas, int horasRestantesModalidade, String documento) {
        this.requerimento = requerimento;
        this.atividade = atividade;
        this.horasApresentadas = horasApresentadas;
        this.horasRestantesModalidade = horasRestantesModalidade;
        this.documento = documento;
    }

    public int horasRestantesModalidade() {
        return horasRestantesModalidade;
    }

    public int horasApresentadas(){
        return this.horasApresentadas;
    }

    public AtividadeComplementar atividade(){
        return this.atividade;
    }

    public String documento(){
        return this.documento;
    }

    public void definirObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String observacao(){
        return this.observacao;
    }
}
