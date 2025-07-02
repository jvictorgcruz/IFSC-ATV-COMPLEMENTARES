package ifsc.jvgc.model;

import ifsc.jvgc.model.requerimento.Requerimento;

public class AtividadeRealizada {
    private int id;
    private final Requerimento requerimento;
    private final AtividadeComplementar atividade;
    private final int horasApresentadas;
    private final int horasRestantesModalidade;
    private final int horasRestantesAtividade;
    private final String documento;
    private String observacao = "";

    public AtividadeRealizada(Requerimento requerimento, AtividadeComplementar atividade,
                              int horasApresentadas, int horasRestantesModalidade, int horasRestantesAtividade,String documento) {
        this.requerimento = requerimento;
        this.atividade = atividade;
        this.horasApresentadas = horasApresentadas;
        this.horasRestantesModalidade = horasRestantesModalidade;
        this.horasRestantesAtividade = horasRestantesAtividade;
        this.documento = documento;
    }

    public int horasRestantesModalidade() {
        return horasRestantesModalidade;
    }

    public int horasRestantesAtividade() {
        return horasRestantesAtividade;
    }

    public int horasApresentadas(){
        return this.horasApresentadas;
    }

    public AtividadeComplementar atividade(){
        return this.atividade;
    }

    public String documento(){
        return this.documento;
    }

    public void definirObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String observacao(){
        return this.observacao;
    }
}
