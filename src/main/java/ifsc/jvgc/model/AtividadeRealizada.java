package ifsc.jvgc.model;

public class AtividadeRealizada {
    private final int id;
    private final Requerimento requerimento;
    private final AtividadeComplementar atividade;
    private final int horasApresentadas;
    private final String documento;
    private int horasValidadas = 0;
    private String observacao = "";

    public AtividadeRealizada(int id, Requerimento requerimento, AtividadeComplementar atividade,
                              int horasApresentadas, String documento) {
        this.id = id;
        this.requerimento = requerimento;
        this.atividade = atividade;
        this.horasApresentadas = horasApresentadas;
        this.documento = documento;
    }

    @Override
    public String toString() {
        return "AtividadeRealizada{id=" + id + ", horasApresentadas=" + horasApresentadas + "}";
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

    public void definirHorasValidadas(int horasValidadas) {
        this.horasValidadas = horasValidadas;
    }

    public int horasValidadas(){
        return horasValidadas;
    }

    public void definirObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String observacao(){
        return this.observacao;
    }
}
