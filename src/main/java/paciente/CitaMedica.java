package paciente;

import java.util.Date;

public class CitaMedica {
    private Paciente paciente;
    private Date fecha;
    private String motivo;

    public CitaMedica(Paciente paciente, Date fecha, String motivo) {
        this.paciente = paciente;
        this.fecha = fecha;
        this.motivo = motivo;
    }

    // Getters y setters

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "CitaMedica{" +
                "paciente=" + paciente +
                ", fecha=" + fecha +
                ", motivo='" + motivo + '\'' +
                '}';
    }
}
