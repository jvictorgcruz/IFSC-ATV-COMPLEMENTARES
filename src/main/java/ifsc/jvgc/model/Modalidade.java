package ifsc.jvgc.model;

public class Modalidade {
    private final int id;
    private final String nome;

    public Modalidade(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Modalidade{id=" + id + ", nome='" + nome + "'}";
    }

    public String getNome() {
        return nome;
    }
}
