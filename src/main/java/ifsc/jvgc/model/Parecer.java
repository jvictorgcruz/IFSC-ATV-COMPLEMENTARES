package ifsc.jvgc.model;

import java.time.LocalDate;

public class Parecer {
    private final int id;
    private final Requerimento requerimento;
    private final String texto;
    private final LocalDate dataParecer;

    public Parecer(int id, Requerimento requerimento, String texto, LocalDate dataParecer) {
        this.id = id;
        this.requerimento = requerimento;
        this.texto = texto;
        this.dataParecer = dataParecer;
    }

    @Override
    public String toString() {
        return "Parecer{id=" + id + ", texto='" + texto + "'}";
    }
}
