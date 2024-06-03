package Servicios;

import paciente.Paciente;
import paciente.CitaMedica;
import paciente.FichaMedica;
import doctor.Doctor;
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

    // Métodos para que un doctor modifique la ficha del paciente
    public void modificarFicha(String rut, String nuevoHistorial) {
        FichaMedica ficha = fichasMedicas.get(rut);
        if (ficha != null) {
            ficha.agregarHistorial(nuevoHistorial);
        } else {
            System.out.println("Ficha no encontrada para el paciente con RUT: " + rut);
        }
    }

    // Métodos para que un doctor agende una cita para el paciente
    public void agendarCita(Paciente paciente, Date fecha, String motivo, Doctor doctor) {
        CitaMedica cita = new CitaMedica(paciente, fecha, motivo + " con Dr. " + doctor.getNombre());
        registrarCita(cita);
    }

    // Métodos para que un doctor modifique la información de un paciente
    public void modificarPaciente(String rut, Paciente nuevoPaciente) {
        for (int i = 0; i < pacientes.size(); i++) {
            if (pacientes.get(i).getRut().equals(rut)) {
                pacientes.set(i, nuevoPaciente);
                fichasMedicas.put(rut, new FichaMedica(nuevoPaciente));
                return;
            }
        }
        System.out.println("Paciente no encontrado con RUT: " + rut);
    }

    // Métodos para que un doctor elimine un paciente
    public void eliminarPaciente(String rut) {
        pacientes.removeIf(paciente -> paciente.getRut().equals(rut));
        fichasMedicas.remove(rut);
    }

    public static void main(String[] args) {
        GestionUsuarios gestionUsuarios = new GestionUsuarios();
        GestionPacientes gestionPacientes = new GestionPacientes();

        // Cargar datos desde archivos CSV
        ArchivoUtil.cargarUsuarios(gestionUsuarios.getUsuarios());
        ArchivoUtil.cargarPacientes(gestionPacientes.getPacientes(), gestionPacientes.fichasMedicas);

        // Registro de un nuevo usuario
        gestionUsuarios.registrarUsuario("12345678-9", "password123");

        // Inicio de sesión
        Usuario usuario = gestionUsuarios.iniciarSesion("12345678-9", "password123");
        if (usuario != null) {
            // Registro de un nuevo paciente
            Paciente paciente = new Paciente("Juan Perez", "12345678-9", "O+", "Soltero", "Calle Falsa 123", "Ninguna");
            gestionPacientes.registrarPaciente(paciente);

            // Registro de un nuevo doctor
            Doctor doctor = new Doctor("Dr. Smith", "Cardiología");

            // Agendar una nueva cita médica
            gestionPacientes.agendarCita(paciente, new Date(), "Consulta General", doctor);

            // Modificar ficha médica
            gestionPacientes.modificarFicha(paciente.getRut(), "Consulta realizada el " + new Date());

            // Modificar información del paciente
            Paciente nuevoPaciente = new Paciente("Juan Perez Modificado", "12345678-9", "A+", "Casado", "Calle Verdadera 456", "Diabetes");
            gestionPacientes.modificarPaciente(paciente.getRut(), nuevoPaciente);

            // Eliminar paciente
            gestionPacientes.eliminarPaciente(paciente.getRut());

            // Guardar datos en archivos CSV
            ArchivoUtil.guardarUsuarios(gestionUsuarios.getUsuarios());
            ArchivoUtil.guardarPacientes(gestionPacientes.getPacientes(), gestionPacientes.fichasMedicas);

            // Mostrar pacientes y citas registrados
            System.out.println("Pacientes registrados:");
            for (Paciente p : gestionPacientes.getPacientes()) {
                System.out.println(p);
            }

            System.out.println("\nCitas registradas:");
            for (CitaMedica c : gestionPacientes.getCitas()) {
                System.out.println(c);
            }

            // Mostrar ficha médica del paciente si aún existe
            FichaMedica ficha = gestionPacientes.getFichaMedica(paciente.getRut());
            if (ficha != null) {
                System.out.println("\nFicha médica del paciente:");
                System.out.println(ficha.getPaciente());
                for (String historial : ficha.getHistoriales()) {
                    System.out.println(historial);
                }
            }
        }
    }

    public Map<String, FichaMedica> getFichasMedicas() {
        return Map.of();
    }

    public List<Paciente> getPacientes(Paciente paciente) {
        return List.of();
    }

    public void agregarPaciente(Paciente paciente) {
    }
}
