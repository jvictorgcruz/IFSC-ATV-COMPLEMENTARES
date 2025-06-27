package ifsc.jvgc.model.entities;

public class AtividadeRealizada {
    private int id;
    private final Requerimento requerimento;
    private final AtividadeComplementar atividade;
    private final int horasApresentadas;
    private final String documento;
    private String observacao = "";

    public AtividadeRealizada(Requerimento requerimento, AtividadeComplementar atividade,
                              int horasApresentadas, String documento) {
        this.requerimento = requerimento;
        this.atividade = atividade;
        this.horasApresentadas = horasApresentadas;
        this.documento = documento;
    }

    public int horasApresentadas(){
        return this.horasApresentadas;
    }

    public AtividadeComplementar atividade(){
        return this.atividade;
    }

    public int id(){
        return this.id;
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
