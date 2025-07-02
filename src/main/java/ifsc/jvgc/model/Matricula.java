package ifsc.jvgc.model;

public class Matricula {
    private int id;
    private Curso curso;
    private Aluno aluno;

    public Matricula(int id, Curso curso, Aluno aluno) {
        this.id = id;
        this.curso = curso;
        this.aluno = aluno;
    }

    public int id(){
        return id;
    }

    public int horasMinimasComplementaresCurso(){
        return this.curso.horasMinimasComplementares();
    }
}
