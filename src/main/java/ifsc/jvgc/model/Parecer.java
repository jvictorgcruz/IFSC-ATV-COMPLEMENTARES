package ifsc.jvgc.model;

import java.time.LocalDate;

public class Parecer {
    private int id;
    private final Requerimento requerimento;
    private final String texto;
    private final LocalDate dataParecer;

    public Parecer(Requerimento requerimento, String texto, LocalDate dataParecer) {
        this.requerimento = requerimento;
        this.texto = texto;
        this.dataParecer = dataParecer;
    }

}
