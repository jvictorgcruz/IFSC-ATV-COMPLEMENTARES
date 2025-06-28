package ifsc.jvgc.model.entities;

public class Curso {
    private int id;
    private String nome;
    private int horasMinimasComplementares;

    public Curso(String nome, int horasMinimasComplementares) {
        this.nome = nome;
        this.horasMinimasComplementares = horasMinimasComplementares;
    }

    public String nome() {
        return nome;
    }

    public int horasMinimasComplementares() {
        return horasMinimasComplementares;
    }
}
