package Servicios;

import Servicio.GestionUsuarios;
import paciente.Paciente;
import paciente.CitaMedica;
import paciente.FichaMedica;
import paciente.Usuario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class GestionPacientes {
    private List<Paciente> pacientes;
    private List<CitaMedica> citas;
    private Map<String, FichaMedica> fichasMedicas;

    public GestionPacientes() {
        this.pacientes = new ArrayList<>();
        this.citas = new ArrayList<>();
        this.fichasMedicas = new HashMap<>();
    }

    public void registrarPaciente(Paciente paciente) {
        pacientes.add(paciente);
        fichasMedicas.put(paciente.getRut(), new FichaMedica(paciente));
    }

    public void registrarCita(CitaMedica cita) {
        citas.add(cita);
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public List<CitaMedica> getCitas() {
        return citas;
    }

    public FichaMedica getFichaMedica(String rut) {
        return fichasMedicas.get(rut);
    }

    public static void main(String[] args) {
        GestionUsuarios gestionUsuarios;
        gestionUsuarios = new Servicio.GestionUsuarios();
        GestionPacientes gestionPacientes = new GestionPacientes();

        // Registro de un nuevo usuario
        gestionUsuarios.registrarUsuario("12345678-9", "password123");

        // Inicio de sesión
        Usuario usuario = gestionUsuarios.iniciarSesion("12345678-9", "password123");
        if (usuario != null) {
            // Registro de un nuevo paciente
            Paciente paciente = new Paciente("Juan Perez", "12345678-9", "O+", "Soltero", "Calle Falsa 123", "Ninguna");
            gestionPacientes.registrarPaciente(paciente);

            // Registro de una nueva cita médica
            CitaMedica cita = new CitaMedica(paciente, new Date(), "Consulta General");
            gestionPacientes.registrarCita(cita);

            // Agregar historial médico
            FichaMedica ficha = gestionPacientes.getFichaMedica(paciente.getRut());
            ficha.agregarHistorial("Consulta realizada el " + new Date());

            // Mostrar pacientes y citas registrados
            System.out.println("Pacientes registrados:");
            for (Paciente p : gestionPacientes.getPacientes()) {
                System.out.println(p);
            }

            System.out.println("\nCitas registradas:");
            for (CitaMedica c : gestionPacientes.getCitas()) {
                System.out.println(c);
            }

            // Mostrar ficha médica del paciente
            System.out.println("\nFicha médica del paciente:");
            System.out.println(ficha.getPaciente());
            for (String historial : ficha.getHistoriales()) {
                System.out.println(historial);
            }
        }
    }
}
