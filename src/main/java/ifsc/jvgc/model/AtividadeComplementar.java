package ifsc.jvgc.model;

public class AtividadeComplementar {
    private final int id;
    private final String descricao;
    private final DocumentacaoComprobatoria documentacao;
    private final HorasPorAtividade horasPorAtividade;
    private final int limiteMaximo;
    private final Modalidade modalidade;

    public AtividadeComplementar(int id, String descricao, DocumentacaoComprobatoria documentacao,
                                 HorasPorAtividade horasPorAtividade, int limiteMaximo, Modalidade modalidade) {
        this.id = id;
        this.descricao = descricao;
        this.documentacao = documentacao;
        this.horasPorAtividade = horasPorAtividade;
        this.limiteMaximo = limiteMaximo;
        this.modalidade = modalidade;
    }

    @Override
    public String toString() {
        return "AtividadeComplementar{id=" + id + ", descricao='" + descricao + "'}";
    }
}
