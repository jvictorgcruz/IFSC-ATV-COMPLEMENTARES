package ifsc.jvgc.model;

public class DocumentacaoComprobatoria {
    private final int id;
    private final String descricao;

    public DocumentacaoComprobatoria(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Documentacao{id=" + id + ", descricao='" + descricao + "'}";
    }
}
