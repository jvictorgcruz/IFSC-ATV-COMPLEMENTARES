package ifsc.jvgc.model;

public class HorasPorAtividade {
    private final int id;
    private final String descricao;

    public HorasPorAtividade(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "HorasPorAtividade{id=" + id + ", descricao='" + descricao + "'}";
    }
}
