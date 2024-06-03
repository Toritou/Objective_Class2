package Menu;

import paciente.Paciente;
import paciente.CitaMedica;
import paciente.FichaMedica;
import paciente.Usuario;
import doctor.Doctor;
import Servicios.GestionPacientes;
import Servicios.GestionUsuarios;
import Servicios.ArchivoUtil;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class MenuPrincipal {
    private GestionUsuarios gestionUsuarios;
    private GestionPacientes gestionPacientes;
    private List<Doctor> doctores;
    private Scanner scanner;

    public MenuPrincipal() {
        this.gestionUsuarios = new GestionUsuarios();
        this.gestionPacientes = new GestionPacientes();
        this.scanner = new Scanner(System.in);

        // Cargar datos desde archivos CSV
        ArchivoUtil.cargarUsuarios(gestionUsuarios.getUsuarios());
        ArchivoUtil.cargarPacientes(gestionPacientes.getPacientes(), gestionPacientes.getFichasMedicas());

        // Lista de doctores predefinidos
        doctores = new ArrayList<>();
        doctores.add(new Doctor("Dr. Juan Pérez", "Cardiología"));
        doctores.add(new Doctor("Dr. Ana García", "Pediatría"));
        doctores.add(new Doctor("Dr. Carlos López", "Dermatología"));
    }

    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.mostrarMenuPrincipal();
    }

    public void mostrarMenuPrincipal() {
        int opcion;
        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Ingresar como Doctor");
            System.out.println("2. Ingresar como Paciente");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    iniciarSesionDoctor();
                    break;
                case 2:
                    mostrarMenuPaciente();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }

    public void iniciarSesionDoctor() {
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su especialidad: ");
        String especialidad = scanner.nextLine();
        Doctor doctor = new Doctor(nombre, especialidad);

        if (doctores.contains(doctor)) {
            System.out.println("Bienvenido, " + nombre);
            mostrarMenuDoctor(doctor);
        } else {
            System.out.println("Doctor no encontrado. Verifique sus credenciales.");
        }
    }

    public void mostrarMenuPaciente() {
        int opcion;
        do {
            System.out.println("\n--- Menú Paciente ---");
            System.out.println("1. Registrarse");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    registrarPaciente();
                    break;
                case 2:
                    iniciarSesionPaciente();
                    break;
                case 3:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }

    public void registrarPaciente() {
        System.out.print("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese su RUT: ");
        String rut = scanner.nextLine();
        System.out.print("Ingrese su tipo de sangre: ");
        String tipoSangre = scanner.nextLine();
        System.out.print("Ingrese su estado civil: ");
        String estadoCivil = scanner.nextLine();
        System.out.print("Ingrese su dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese su enfermedad preexistente: ");
        String enfermedad = scanner.nextLine();
        System.out.print("Cree una contraseña: ");
        String password = scanner.nextLine();

        Paciente paciente = new Paciente(nombre, rut, tipoSangre, estadoCivil, direccion, enfermedad);
        Usuario usuario = new Usuario(rut, password);

        // Agregar paciente y usuario a las listas
        gestionPacientes.agregarPaciente(paciente);
        gestionUsuarios.agregarUsuario(usuario);

        // Guardar en archivos
        ArchivoUtil.guardarUsuarios(gestionUsuarios.getUsuarios());
        ArchivoUtil.guardarPacientes(gestionPacientes.getPacientes());

        System.out.println("Paciente registrado con éxito.");
    }


    public void iniciarSesionPaciente() {
        System.out.print("Ingrese su RUT: ");
        String rut = scanner.nextLine();
        System.out.print("Ingrese su contraseña: ");
        String password = scanner.nextLine();

        Usuario usuario = gestionUsuarios.iniciarSesion(rut, password);
        if (usuario == null) {
            System.out.println("Inicio de sesión fallido. Verifique sus credenciales.");
            return;
        }

        mostrarMenuPacienteAutenticado(rut);
    }

    public void mostrarMenuPacienteAutenticado(String rut) {
        int opcion;
        do {
            System.out.println("\n--- Menú Paciente Autenticado ---");
            System.out.println("1. Ver ficha médica");
            System.out.println("2. Ver citas médicas");
            System.out.println("3. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    verFichaMedica(rut);
                    break;
                case 2:
                    verCitasMedicas(rut);
                    break;
                case 3:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 3);
    }

    // Métodos para las operaciones del Doctor
    public void mostrarMenuDoctor(Doctor doctor) {
        int opcion;
        do {
            System.out.println("\n--- Menú Doctor ---");
            System.out.println("1. Modificar ficha del paciente");
            System.out.println("2. Agendar cita para el paciente");
            System.out.println("3. Modificar información del paciente");
            System.out.println("4. Eliminar paciente");
            System.out.println("5. Regresar al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea

            switch (opcion) {
                case 1:
                    modificarFichaPaciente();
                    break;
                case 2:
                    agendarCita(doctor);
                    break;
                case 3:
                    modificarPaciente();
                    break;
                case 4:
                    eliminarPaciente();
                    break;
                case 5:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 5);
    }

    // Métodos del doctor
    private void modificarFichaPaciente() {
        System.out.print("Ingrese el RUT del paciente: ");
        String rut = scanner.nextLine();
        System.out.print("Ingrese el nuevo historial médico: ");
        String historial = scanner.nextLine();
        gestionPacientes.modificarFicha(rut, historial);
    }

    private void agendarCita(Doctor doctor) {
        System.out.print("Ingrese el RUT del paciente: ");
        String rut = scanner.nextLine();
        System.out.print("Ingrese la fecha de la cita (YYYY-MM-DD): ");
        String fechaStr = scanner.nextLine();
        System.out.print("Ingrese el motivo de la cita: ");
        String motivo = scanner.nextLine();

        try {
            Date fecha = new Date(fechaStr); // Asumiendo un formato simple de fecha para este ejemplo
            Paciente paciente = gestionPacientes.getPacientes().stream()
                    .filter(p -> p.getRut().equals(rut))
                    .findFirst()
                    .orElse(null);
            if (paciente != null) {
                gestionPacientes.agendarCita(paciente, fecha, motivo, doctor);
            } else {
                System.out.println("Paciente no encontrado con RUT: " + rut);
            }
        } catch (Exception e) {
            System.out.println("Error al parsear la fecha. Intente de nuevo.");
        }
    }

    private void modificarPaciente() {
        System.out.print("Ingrese el RUT del paciente a modificar: ");
        String rut = scanner.nextLine();
        System.out.print("Ingrese el nuevo nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el nuevo tipo de sangre: ");
        String tipoSangre = scanner.nextLine();
        System.out.print("Ingrese el nuevo estado civil: ");
        String estadoCivil = scanner.nextLine();
        System.out.print("Ingrese la nueva dirección: ");
        String direccion = scanner.nextLine();
        System.out.print("Ingrese la nueva enfermedad preexistente: ");
        String enfermedad = scanner.nextLine();

        Paciente nuevoPaciente = new Paciente(nombre, rut, tipoSangre, estadoCivil, direccion, enfermedad);
        gestionPacientes.modificarPaciente(rut, nuevoPaciente);
    }

    private void eliminarPaciente() {
        System.out.print("Ingrese el RUT del paciente a eliminar: ");
        String rut = scanner.nextLine();
        gestionPacientes.eliminarPaciente(rut);
    }

    // Métodos para las operaciones del Paciente
    private void verFichaMedica(String rut) {
        FichaMedica ficha = gestionPacientes.getFichaMedica(rut);
        if (ficha != null) {
            System.out.println("\nFicha médica del paciente:");
            System.out.println(ficha.getPaciente());
            for (String historial : ficha.getHistoriales()) {
                System.out.println(historial);
            }
        } else {
            System.out.println("Ficha médica no encontrada para el paciente con RUT: " + rut);
        }
    }

    private void verCitasMedicas(String rut) {
        List<CitaMedica> citas = gestionPacientes.getCitas();
        System.out.println("\nCitas médicas del paciente:");
        for (CitaMedica cita : citas) {
            if (cita.getPaciente().getRut().equals(rut)) {
                System.out.println(cita);
            }
        }
    }
}

