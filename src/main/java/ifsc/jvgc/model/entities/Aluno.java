package ifsc.jvgc.model.entities;

public class Aluno {
    private int id;
    private final String nome;

    public Aluno(String nome) {
        this.nome = nome;
    }

    public int id() {
        return id;
    }
}
