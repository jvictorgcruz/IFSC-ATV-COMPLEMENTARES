package ifsc.jvgc.model;

public class HorasPorAtividade {
    private int id;
    private final String descricao;

    public HorasPorAtividade(String descricao) {
        this.descricao = descricao;
    }

    public String descricao() {
        return descricao;
    }

}
