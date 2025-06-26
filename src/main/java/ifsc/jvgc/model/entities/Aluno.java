package ifsc.jvgc.model.entities;

public class Aluno {
    private final int matricula;
    private final String nome;

    public Aluno(int matricula, String nome) {
        this.matricula = matricula;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Aluno{matricula=" + matricula + ", nome='" + nome + "'}";
    }

    public int matricula() {
        return matricula;
    }
}
