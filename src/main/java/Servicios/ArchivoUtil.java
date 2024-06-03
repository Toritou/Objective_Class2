package Servicios;

import paciente.Paciente;
import paciente.FichaMedica;
import paciente.Usuario;

import java.io.*;
import java.util.List;
import java.util.Map;

public class ArchivoUtil {

    private static final String PACIENTES_FILE = "pacientes.csv";
    private static final String USUARIOS_FILE = "usuarios.csv";

    // Método para guardar pacientes en archivo CSV
    public static void guardarPacientes(List<Paciente> pacientes, Map<String, FichaMedica> fichasMedicas) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(PACIENTES_FILE))) {
            for (Paciente paciente : pacientes) {
                FichaMedica ficha = fichasMedicas.get(paciente.getRut());
                writer.printf("%s,%s,%s,%s,%s,%s,%s%n",
                        paciente.getNombre(),
                        paciente.getRut(),
                        paciente.getTipoSangre(),
                        paciente.getEstadoCivil(),
                        paciente.getDomicilio(),
                        paciente.getFichaMedica(),
                        ficha != null ? String.join(";", ficha.getHistoriales()) : ""
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para guardar usuarios en archivo CSV
    public static void guardarUsuarios(Map<String, Usuario> usuarios) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USUARIOS_FILE))) {
            for (Usuario usuario : usuarios.values()) {
                writer.printf("%s,%s%n", usuario.getRut(), usuario.getContrasena());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar usuarios desde archivo CSV
    public static void cargarUsuarios(Map<String, Usuario> usuarios) {
        try (BufferedReader reader = new BufferedReader(new FileReader(USUARIOS_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    usuarios.put(parts[0], new Usuario(parts[0], parts[1]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para cargar pacientes desde archivo CSV
    public static void cargarPacientes(List<Paciente> pacientes, Map<String, FichaMedica> fichasMedicas) {
        try (BufferedReader reader = new BufferedReader(new FileReader(PACIENTES_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 6) {
                    Paciente paciente = new Paciente(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
                    pacientes.add(paciente);
                    if (parts.length == 7) {
                        FichaMedica ficha = new FichaMedica(paciente);
                        String[] historiales = parts[6].split(";");
                        for (String historial : historiales) {
                            ficha.agregarHistorial(historial);
                        }
                        fichasMedicas.put(paciente.getRut(), ficha);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarPacientes(List<Paciente> pacientes) {
    }
}
