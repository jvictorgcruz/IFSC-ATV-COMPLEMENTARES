package ifsc.jvgc.model.modalidade;

import ifsc.jvgc.model.modalidade.tipos.*;

public enum ModalidadeTipo {
    ENSINO(1, "Ensino", new Ensino()),
    PESQUISA(2, "Pesquisa e Inovação", new PesquisaInovacao()),
    EXTENSAO(3, "Extensão", new Extensao()),
    COMPLEMENTACAO(4, "Complementação", new Complementacao());

    private final int id;
    private final String nome;
    private final Modalidade modalidade;

    ModalidadeTipo(int id, String nome, Modalidade modalidade) {
        this.id = id;
        this.nome = nome;
        this.modalidade = modalidade;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Modalidade getModalidade() {
        return modalidade;
    }

    public static ModalidadeTipo fromId(int id) {
        for (ModalidadeTipo tipo : values()) {
            if (tipo.id == id) return tipo;
        }
        return null;
    }
}
