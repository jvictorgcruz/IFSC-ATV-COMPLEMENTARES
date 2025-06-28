package ifsc.jvgc.model.entities;

public class Matricula {
    private int id;
    private Curso curso;
    private Aluno aluno;

    public Matricula(int id, Curso curso, Aluno aluno) {
        this.curso = curso;
        this.aluno = aluno;
    }

    public int id(){
        return id;
    }

    public Curso curso() {
        return curso;
    }

    public Aluno aluno() {
        return aluno;
    }
}
