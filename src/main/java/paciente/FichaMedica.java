package paciente;

import java.util.ArrayList;
import java.util.List;

public class FichaMedica {
    private Paciente paciente;
    private List<String> historiales;

    public FichaMedica(Paciente paciente) {
        this.paciente = paciente;
        this.historiales = new ArrayList<>();
    }

    public void agregarHistorial(String historial) {
        historiales.add(historial);
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public List<String> getHistoriales() {
        return historiales;
    }
}
