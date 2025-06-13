package ifsc.jvgc.model;

public class Aluno {
    private final int id;
    private final String nome;

    public Aluno(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Aluno{id=" + id + ", nome='" + nome + "'}";
    }
}
