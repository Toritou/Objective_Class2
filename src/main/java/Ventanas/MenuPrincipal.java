package Ventanas;

import javax.swing.*;

public class MenuPrincipal {
    public MenuPrincipal() {
        mostrarMenuPrincipal();
    }

    private void mostrarMenuPrincipal() {
        String[] opciones = {"Ingresar como Doctor", "Ingresar como Paciente", "Salir"};

        int opcionSeleccionada = JOptionPane.showOptionDialog(null, "Seleccione una opción",
                "Menú Principal", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, opciones, opciones[0]);

        switch (opcionSeleccionada) {
            case 0:
                mostrarVentanaIngresarDoctor();
                break;
            case 1:
                mostrarVentanaIngresarPaciente();
                break;
            case 2:
                System.out.println("Saliendo...");
                System.exit(0);
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private void mostrarVentanaIngresarDoctor() {
        VentanaIngresarDoctor ventana = new VentanaIngresarDoctor();
        ventana.setVisible(true);
    }

    private void mostrarVentanaIngresarPaciente() {
        VentanaIngresarPaciente ventana = new VentanaIngresarPaciente();
        ventana.setVisible(true);
    }

    public static void main(String[] args) {
        new MenuPrincipal();
    }
}
