package ifsc.jvgc.model;

public class AtividadeRealizada {
    private final int id;
    private final Requerimento requerimento;
    private final AtividadeComplementar atividade;
    private final int horasApresentadas;
    private final String documento;

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
}
