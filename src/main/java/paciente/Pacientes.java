package paciente;

public class Pacientes {
    private String nombre;
    private String rut;
    private String tipoSangre;
    private String estadoCivil;
    private String domicilio;
    private String fichaMedica;

    public Pacientes(String nombre, String rut, String tipoSangre, String estadoCivil, String domicilio, String fichaMedica) {
        this.nombre = nombre;
        this.rut = rut;
        this.tipoSangre = tipoSangre;
        this.estadoCivil = estadoCivil;
        this.domicilio = domicilio;
        this.fichaMedica = fichaMedica;
    }

    //Metodos getter y setters

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }
    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }
    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getDomicilio() {
        return domicilio;
    }
    public void setDomicilio(String domicilio){
        this.domicilio = domicilio;
    }

    public String getFichaMedica() {
        return fichaMedica;
    }
    public void setFichaMedica(String fichaMedica) {
        this.fichaMedica = fichaMedica;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", rut='" + rut + '\'' +
                ", tipoSangre='" + tipoSangre + '\'' +
                ", estadoCivil='" + estadoCivil + '\'' +
                ", domicilio='" + domicilio + '\'' +
                ", enfermedades='" + fichaMedica + '\'' +
                '}';
    }
}